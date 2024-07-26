package org.god.ibatis.test;

import org.god.ibatis.core.SqlSession;
import org.god.ibatis.core.SqlSessionFactory;
import org.god.ibatis.core.SqlSessionFactoryBuilder;
import org.god.ibatis.pojo.User;
import org.god.ibatis.utils.Resources;
import org.junit.Test;

/**
 * @author 杜嘉豪
 * @create 2024/4/17 23:27
 * @description:
 */
public class GodBatisTest {
    @Test
    public void testSqlSessionFactory(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("godbatis-config.xml"));
        System.out.println(sqlSessionFactory);
    }


    @Test
    public void testInsert(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("godbatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行SQL insert
        User user=new User("1118","zhangan","20");
        sqlSession.insert("user.insertUser",user);
        sqlSession.commit();
    }

}
