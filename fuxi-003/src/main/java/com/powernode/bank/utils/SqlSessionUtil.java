package com.powernode.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 16:35
 * @description:
 */
public class SqlSessionUtil {
    private SqlSessionUtil(){};
    private static SqlSessionFactory factory;

    static {
        try {
             factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  static SqlSession openSession(){
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

}
