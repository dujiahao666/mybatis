package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @author 杜嘉豪
 * @create 2024/4/15 23:24
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testSelectByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByPrimaryKey(59l);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testDeleteByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteByPrimaryKey(66l);
        System.out.println(i+"条");
        sqlSession.commit();
        sqlSession.close();
    }
}
