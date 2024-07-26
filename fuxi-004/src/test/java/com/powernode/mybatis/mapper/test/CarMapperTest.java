package com.powernode.mybatis.mapper.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 15:02
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "911", "保时捷", 500.00, "就是今天", "看看就好了");
        mapper.insert(car);
        System.out.println("关键的来了" + car);
        System.out.println("关键的来了" + car.getId());
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeletebyId() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteByid(135l);
        System.out.println("改变的记录条数" + i);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.update(new Car(136l, "12174", "遨游九天", 12.34, "就是今天", "二代来袭"));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }


    @Test
    public void testSelectByid() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByid(136l);
        System.out.println(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        System.out.println(cars);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }


    @Test
    public void testselectSome() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectSome("保时捷", 500.00);
        System.out.println(cars);
    }

    @Test
    public void testselectBrand() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        String s = mapper.slectBrand(137l);
        System.out.println(s);
    }

    @Test
    public void testselectBrandtwo() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Objects> stringObjectsMap = mapper.slectBrand2(137l);
        System.out.println(stringObjectsMap);
    }


    @Test
    public void testselectBrandtwo2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> longMapMap = mapper.selectHaha();
        Set<Map.Entry<Long, Map<String, Object>>> entries = longMapMap.entrySet();
        System.out.println(entries);
    }

    @Test
    public void testselectBrandtwo2selectOa() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectOa("奔驰");
        System.out.println(cars);
    }

    @Test
    public void testDaba(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> daba = mapper.daba("奔驰", "燃油车", 22.00);
//        List<Car> daba = mapper.daba(null, null, null);
        System.out.println(daba);
    }

    @Test
    public void testUpdatetSet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.updatetSet(new Car(65l,"1112","奔驰的小野马",22.21,"2024-10-01","收藏款ne?"));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelect6(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.select6(null, null, "燃油车");
        System.out.println(cars);
    }

    @Test
    public void testSdel() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids={131l,132l};
        int del = mapper.del(ids);
        sqlSession.commit();
    }

    @Test
    public void testJicha(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> jicha = mapper.jicha();
        System.out.println(jicha);
    }


    @Test
    public void testJk(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> bc = mapper.jk("奔驰");
        System.out.println(bc);
    }




    }
