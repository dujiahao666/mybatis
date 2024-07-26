package com.powernode.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author 杜嘉豪
 * @create 2024/3/28 10:42
 * @description:
 */
public class MyBatisIntrodution {
    public static void main(String[] args) throws Exception{
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);//一般情况下都是一个数据库对应一个SqlSessionFactory对象

        //获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);   //不建议这里写true,因为没有开启事务，即使可以在后面节省一行代码
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        //执行SQL语句
        int insertCar = sqlSession.insert("insertCar");  //这里写的是xxxMapper.xml的唯一id
//        int insertCar2 = sqlSession2.insert("insertCar");  //这里写的是xxxMapper.xml的唯一id

        System.out.println("插入了："+insertCar+"条数据");
//        System.out.println("插入了："+insertCar2+"条数据");

        //手动提交
        sqlSession.commit();
//        sqlSession2.commit();
    }
}
