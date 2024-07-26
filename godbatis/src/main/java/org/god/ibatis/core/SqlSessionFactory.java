package org.god.ibatis.core;

import java.util.Map;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 21:16
 * @description:      SqlSessionFactory对象：
 *                          一个数据库对应一个SqlSessionFactory对象
 *                          通过SqlSessionFactory对象可以获取SqlSession对象（开启会话）
 *                          一个SqlSessionFactory对象可以开启多个SqlSession会话。
 */
public class SqlSessionFactory {

    /**
     * 事务管理器属性
     * [经典的设计：面相接口编程]
     */
    private Transaction transaction;

    //数据源属性【这里没有存在的意义了，直接在事物管理器中弄好就行了】


    /**
     * 存放sql语句的Map集合
     * key是sqlid
     * value是对应的SQL标签信息对象【MappedStatement类进行封装】
     */
    private Map<String,MappedStatement> mappedStatements;


    public SqlSessionFactory() {
    }

    public SqlSessionFactory(Transaction transaction, Map<String, MappedStatement> mappedStatements) {
        this.transaction = transaction;
        this.mappedStatements = mappedStatements;
    }


    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Map<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(Map<String, MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }


    public SqlSession openSession(){
        //开启会话的前提是开启连接（连接打开了）
        transaction.openConnection();
        //创建sqlSession对象
        SqlSession sqlSession=new SqlSession(this);  //本质上传入的还是transaction  mappedStatements
        return sqlSession;
    }


}
