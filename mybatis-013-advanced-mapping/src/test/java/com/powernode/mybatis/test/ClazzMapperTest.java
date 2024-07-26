package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.ClazzMapper;
import com.powernode.mybatis.pojo.Clazz;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 杜嘉豪
 * @create 2024/4/14 22:48
 * @description:
 */
public class ClazzMapperTest {

    @Test
    public void testselectByid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByid(1000);
        System.out.println(clazz);
        sqlSession.close();
    }


    @Test
    public void testselectByCollection(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByCollection(1000);
        System.out.println(clazz);
        sqlSession.close();
    }



    @Test
    public void testselectBystep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectBystep1(1001);
        System.out.println(clazz);
//        System.out.println(clazz.getCname());
//        System.out.println(clazz.getStus());
        sqlSession.close();
    }
}
