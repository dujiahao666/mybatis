package com.powernode.curd.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 10:33
 * @description:
 */
public class Zhi {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession(true);
        sqlSession.insert("ok1");
        sqlSession.commit();
        System.out.println("执行完毕");

    }
}
