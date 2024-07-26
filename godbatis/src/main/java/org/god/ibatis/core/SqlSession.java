package org.god.ibatis.core;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 杜嘉豪
 * @create 2024/4/17 23:39
 * @description: 专门负责执行SQL语句的会话对象
 */
public class SqlSession {
    private SqlSessionFactory factory;

    public SqlSession(SqlSessionFactory factory) {
        this.factory = factory;
    }


    //insert

    /**
     * 执行insert语句，向数据库中插入记录
     *
     * @param sqlId sql语句的id
     * @param pojo  插入的数据
     * @return
     */
    public int insert(String sqlId, Object pojo) {
        int count = 0;
        try {
            //JDBC代码，执行insert语句，完成插入操作
            Connection connection = factory.getTransaction().getConnection();
            String godbatisSql = factory.getMappedStatements().get(sqlId).getSql();
            //insert into t_user values (#{id},#{name},#{age})  上面取出来的语句，我们需要进行转化[成为下面的]，才能够使用
            //insert into t_user values(?,?,?)
            String sql = godbatisSql.replaceAll("#\\{[a-zA-Z0-9_$]*}", "?");
            PreparedStatement ps = connection.prepareStatement(sql);
            // 给?占位符传值  难度：一：你不知道有多少个？  二：你不知道该将pojo对象中的哪个属性赋值给哪个 ？ 这里我们都调用 ps.setString(第几个问号,传什么值)  所以数据库中的字段类型都要求是varchar 这是godbatis比较失败的地方
            //#{数据}  里面的数据，就是我们需要插入的数据
            int fromIndex = 0;
            int index = 1;
            while (true) {
                int jingIndex = godbatisSql.indexOf("#", fromIndex);
                if (jingIndex < 0) {
                    break;
                }
                int youKuoHaoIndex = godbatisSql.indexOf("}", fromIndex);
                String propertyName = godbatisSql.substring(jingIndex + 2, youKuoHaoIndex).trim();
                fromIndex = youKuoHaoIndex + 1;
                //有属性名id,怎么获取id的属性值呢？调用getId()方法
                String getMethodName = "get" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                Method getMethod = pojo.getClass().getDeclaredMethod(getMethodName);  //通过反射拿到getId()这个方法
                Object propertyValue = getMethod.invoke(pojo);  //调用方法，得到getId的值【上面传入的参数pojo得到的真实的值】
                ps.setString(index, propertyValue.toString());  //这是进行赋值【传参】
                index++;
            }


            count = ps.executeUpdate();
            //执行sql语句
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }


    // 局部测试
    public static void main(String[] args) {
        String sql = "insert into t_user values (#{id},#{name},#{age})";
        int fromIndex = 0;
        int index = 1;
        while (true) {
            int jingIndex = sql.indexOf("#", fromIndex);
            if (jingIndex < 0) {
                break;
            }
            System.out.println(index);
            index++;
            int youKuoHaoIndex = sql.indexOf("}", fromIndex);
            String propertyName = sql.substring(jingIndex + 2, youKuoHaoIndex).trim();
            System.out.println(propertyName);
            fromIndex = youKuoHaoIndex + 1;
        }
    }


    /**
     * 提交事务
     */
    public void commit() {
        factory.getTransaction().commit();
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        factory.getTransaction().rollback();
    }

    /**
     * 关闭事物
     */
    public void close() {
        factory.getTransaction().close();
    }


    //selectOne
    public Object selectOne(String sqlId, Object param) {
        Object obj = null;
        try {
            Connection connection = factory.getTransaction().getConnection();
            MappedStatement mappedStatement = factory.getMappedStatements().get(sqlId);
            //这是那个DQL查询语句
            //select * from t_user where id= #{id}
            String godbatisSql = mappedStatement.getSql();
            String sql = godbatisSql.replaceAll("#\\{[a-zA-Z0-9_$]*}", "?");
            PreparedStatement ps = connection.prepareStatement(sql);
            //给占位符传值
            ps.setString(1, param.toString());
            //查询返回结果集
            ResultSet rs = ps.executeQuery();
            //要封装的结果类型
            String resultType = mappedStatement.getResultType();
            //从结果集中取数据，封装java对象
            if (rs.next()) {
                //获取resultType的class
                Class<?> resultTypeClass = Class.forName(resultType);
                //调用无参数构造方法创建对象
                obj = resultTypeClass.componentType();  // Object obj = new User();
                //给User类的id,name,age属性赋值
                //【p50集到这里】

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


}
