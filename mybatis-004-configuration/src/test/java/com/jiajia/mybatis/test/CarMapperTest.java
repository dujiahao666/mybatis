package com.jiajia.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @create 2024/4/2 8:49
 * @description:
 */
public class CarMapperTest {

    @Test
    public void testEnvironment() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();


        //这里得到的是默认的环境,一个参数（获取默认环境）
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        sqlSession.insert("car.insertCar");
        sqlSession.commit();
        sqlSession.close();

        //用build对象去创建到底用哪个环境，两个参数（通过环境id，获取指定的环境）
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "mybatisDB");
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        sqlSession1.insert("car.insertCar");
        sqlSession1.commit();
        sqlSession1.close();



    }
}
