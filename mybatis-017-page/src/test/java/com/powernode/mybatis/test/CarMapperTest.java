package com.powernode.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 8:51
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testselectByPage(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByPage(3, 3);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }


    @Test
    public void testselectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //注意：在DQL语句执行之前，开启分页功能；
        PageHelper.startPage(4,3);
        List<Car> cars = mapper.selectAll();
//        cars.forEach(car -> System.out.println(car));
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 10);
        System.out.println(carPageInfo);
        sqlSession.close();
    }



}
