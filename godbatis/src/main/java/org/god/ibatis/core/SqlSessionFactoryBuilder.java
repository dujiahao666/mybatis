package org.god.ibatis.core;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.god.ibatis.utils.Resources;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 21:10
 * @description: SqlSessionFactory构建器对象。
 * 通过SqlSessionFactoryBuilder的build方法来解析 goodbatis-config.xml文件，然后创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactoryBuilder() {
    }


    /**
     * 解析 godbatis-config.xml文件，来构建SqlSessionFactory对象
     *
     * @param in 指向 godbatis-config.xml文件的一个输入流
     * @return SqlSessionFactory对象
     */
    public SqlSessionFactory build(InputStream in) {
        SqlSessionFactory factory = null;
        try {
            //解析godbatis-config.xml文件
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            Element environments = (org.dom4j.Element) document.selectSingleNode("/configuration/environments");
            String defaultId = environments.attributeValue("default");

            //到现在为止【执行了下面的代码之后，当然】已经获取到了<environment id=""></en...>这组数据了
            Element environment = (Element) document.selectSingleNode("/configuration/environments/environment[@id='" + defaultId + "']");
            Element transactionElt = environment.element("transactionManager");
            Element dataSourceElt = environment.element("dataSource");

            List<String> sqlMapperXMLPathList = new ArrayList<>();
            List<Node> nodes = document.selectNodes("//mapper");
            nodes.forEach(node -> {
                Element mapper = (Element) node;
                String resource = mapper.attributeValue("resource");
                sqlMapperXMLPathList.add(resource);
            });

            //获取数据源对象
            DataSource dataSource = getDataSource(dataSourceElt);
            //获取事物管理器
            Transaction transaction = getTransction(transactionElt, dataSource);

            //获取mappedStatements
            Map<String, MappedStatement> mappedStatements = getMappedStatements(sqlMapperXMLPathList);
            factory = new SqlSessionFactory(transaction, mappedStatements);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }


    /**
     * 解析所有的SqlMapper.xml文件，然后构建Map集合
     *
     * @param sqlMapperXMLPathList
     * @return
     */
    private Map<String, MappedStatement> getMappedStatements(List<String> sqlMapperXMLPathList) {
        Map<String, MappedStatement> mappedStatements = new HashMap<>();
        sqlMapperXMLPathList.forEach(sqlMapperXMLPath -> {
            try {
                SAXReader reader = new SAXReader();
                Document document = reader.read(Resources.getResourceAsStream(sqlMapperXMLPath));
                Element mapper = (Element) document.selectSingleNode("mapper");
                String namespace = mapper.attributeValue("namespace");
                List<Element> elements = mapper.elements();
                elements.forEach(element -> {
                    String id = element.attributeValue("id");
                    //这里进行了namespace和id的拼接，生成最终的sqlId
                    String sqlId=namespace+"."+id;

                    String resultType = element.attributeValue("resultType");
                    String sql = element.getTextTrim();
                    MappedStatement mappedStatement = new MappedStatement(sql, resultType);

                    mappedStatements.put(sqlId,mappedStatement);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return mappedStatements;
    }


    /**
     * 获取事物管理器的
     *
     * @param transactionElt 事务管理器标签元素
     * @param dataSource     数据源对象
     * @return
     */
    private Transaction getTransction(Element transactionElt, DataSource dataSource) {
        Transaction transaction = null;
        String type = transactionElt.attributeValue("type").trim().toUpperCase();
        if (Const.JDBC_TRANSACTION.equals(type)) {
            transaction = new JdbcTransction(dataSource, false);  //默认是开启事务的，将来手动提交
        }
        if (Const.MANAGED_TRANSACTION.equals(type)) {
            transaction = new ManagedTransaction();
        }
        return transaction;
    }


    /**
     * 获取数据源对象
     *
     * @param dataSourceElt 数据源标签
     * @return
     */
    private DataSource getDataSource(Element dataSourceElt) {
        Map<String, String> map = new HashMap<>();
        List<Element> propertyElts = dataSourceElt.elements("property");
        propertyElts.forEach(propertyElt -> {
            String name = propertyElt.attributeValue("name");
            String value = propertyElt.attributeValue("value");
            map.put(name, value);
        });

        DataSource dataSource = null;
        // UNPOOLED   POOLED  JNDI
        String type = dataSourceElt.attributeValue("type").trim().toUpperCase();
        if (Const.UN_POOLED_DATASOURCE.equals(type)) {
            dataSource = new UnPooledDataSource(map.get("driver"), map.get("url"), map.get("username"), map.get("password"));
        }
        if (Const.POOLED_DATASOURCE.equals(type)) {
            dataSource = new PooledDataSource();
        }
        if (Const.JNDI_DATASOURCE.equals(type)) {
            dataSource = new JNDIDataSource();
        }
        return dataSource;
    }


}
