package com.powernode.godbatis.test;

import com.powernode.godbatis.pojo.User;
import org.god.ibatis.core.SqlSession;
import org.god.ibatis.core.SqlSessionFactory;
import org.god.ibatis.core.SqlSessionFactoryBuilder;
import org.god.ibatis.utils.Resources;
import org.junit.Test;

/**
 * @author 杜嘉豪
 * @create 2024/4/18 23:22
 * @description:
 */
public class UserMapperTest {
    @Test
    public void testinsertUser(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("godbatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        User user=new User("地球","迪迦","未知");
        int count = sqlSession.insert("user.insertUser", user);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
