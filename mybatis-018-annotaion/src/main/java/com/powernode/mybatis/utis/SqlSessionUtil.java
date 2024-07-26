package com.powernode.mybatis.utis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @create 2024/4/1 20:17
 * @description:
 */
public class SqlSessionUtil {

    //工具类的构造方法一般都是私有化的
    //工具类的所有方法都是静态的，直接采用类名即可调用，不需要new对象
    //为了防止new对象，构造方法私有化
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            //注意：SqlSessionFactory对象：一个SqlSessionFactory对应一个envirnment,一个enviromment通常是一个数据库
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }


    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }


}
