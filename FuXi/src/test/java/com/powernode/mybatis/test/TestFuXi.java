package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/4/23 0:46
 * @description:
 */
public class TestFuXi {
    @Test
    public void testFu(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(1l);
        System.out.println(car);
        sqlSession.close();
    }
}
