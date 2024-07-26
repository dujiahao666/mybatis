package com.jiajia.mylogger.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @create 2024/3/28 18:56
 * @description:
 */
public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            //获得工厂构建对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //通过工厂构建对象 构建 工厂
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //利用工厂创建sqlSession(用来执行sql语句)  开启会话（底层会开启事务）
            sqlSession = sqlSessionFactory.openSession();  //这里是可以控制事务的关闭与开启的，默认true，没有开启事务。
            // 工厂构建出来的东西，决定是否开启事务，厂家出厂规定合情合理

            //执行sql语句，处理相关业务
            int insertCar = sqlSession.insert("insertCar");
            System.out.println("成功插入了"+insertCar+"条数据");
            //执行到这里，没有发生任何异常，提交事务。终止事务
            sqlSession.commit();
        } catch (IOException e) {
            //如果出现了问题，事务回滚
            if(sqlSession!=null){
            sqlSession.rollback();
            }
           e.printStackTrace();
        }finally {
            //关闭会话,释放资源
            if(sqlSession!=null){
            sqlSession.close();
            }
        }

    }
}
