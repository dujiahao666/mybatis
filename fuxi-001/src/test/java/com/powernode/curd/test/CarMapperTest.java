package com.powernode.curd.test;

import com.powernode.curd.pojo.Car;
import com.powernode.curd.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 16:54
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map=new HashMap<>();
        map.put("k1","2597");
        map.put("k2","快乐的贾烈");
        map.put("k3","66.6");
        map.put("k4","2024-07-03");
        map.put("k5","新能源辣");
        int insert1 = sqlSession.insert("ok2", map);
        int insert = insert1;
        System.out.println(insert);
        sqlSession.commit();
    }

    @Test
    public void testInsertCarByPojo(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car=new Car(null,"1259","自创品牌",11.32,"2023","回不到过去");
        sqlSession.insert("ok3",car);
        sqlSession.commit();
    }

    @Test
    public void testSlecetOne(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = sqlSession.selectOne("selectOne", 135);
        System.out.println(car);
    }

    @Test
    public void testSlecetAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = sqlSession.selectList("selectAll");
        System.out.println(cars);
    }

}
