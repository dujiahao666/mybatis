package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author 杜嘉豪
 * @create 2024/4/12 8:35
 * @description:
 */
public class CarMapperTest {

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(59l);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectById2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
//        cars.stream().forEach(car -> System.out.println(car));
        System.out.println(cars);
        sqlSession.close();
    }


    @Test
    public void testselectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByBrandLike("奔");
        System.out.println(car);
        sqlSession.close();
    }


    @Test
    public void testselectByIdRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> map = mapper.selectByIdRetMap(59l);
        map.forEach(new BiConsumer<String, Object>() {
            @Override
            public void accept(String s, Object o) {
                System.out.println(s+":"+o);
            }
        });
        System.out.println("===================");
        System.out.println(map);
        Object o = map.get("car_type");
        System.out.println(o);
        sqlSession.close();
    }


    @Test
    public void testselectByIdRetMapAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> maps = mapper.selectByIdRetMapAll();
        maps.forEach(map-> System.out.println(map));
        sqlSession.close();
        System.out.println("========================");
        System.out.println(maps);
        Object o = maps.get(0).get("ppt");
        System.out.println(o);
        Object o2 = maps.get(0).get("car_num");
        System.out.println(o2);
    }


    @Test
    public void testslectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> lolngMapMap = mapper.slectAllRetMap();
        System.out.println(lolngMapMap);
        sqlSession.close();
        /*
        * 结果集：
        * {
        * 64={car_num=11111, id=64, guide_price=21.92, produce_time=2024-04-09, brand=奔驰, car_type=燃油车},
        * 1={car_num=1112, id=1, guide_price=31.10, produce_time=2000-10-10, brand=凯美瑞, car_type=新能源},
        * 65={car_num=11111, id=65, guide_price=21.92, produce_time=2024-04-09, brand=奔驰, car_type=燃油车},
        * 2={car_num=1113, id=2, guide_price=23.00, produce_time=2001-10-10, brand=比亚迪汉, car_type=新能源},
        * 66={car_num=11111, id=66, guide_price=21.92, produce_time=2024-04-09, brand=奔驰, car_type=燃油车},
        * ……等
        *
        * */
        System.out.println("===========================");
        Map<String, Object> map = lolngMapMap.get(59l);
        System.out.println(map);
        System.out.println(lolngMapMap.get(59l).get("id"));
        System.out.println(lolngMapMap.get(59l).get("brand"));
        System.out.println(lolngMapMap.get(59l).get("car_type"));
    }


    @Test
    public void testselecttest(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> selecttest = mapper.selecttest(59l);
        System.out.println(selecttest);
        sqlSession.close();
    }


    @Test
    public void testselectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        for (Car car : cars) {
            System.out.println(car);
            System.out.println("=============");
        }
        sqlSession.close();
    }



    @Test
    public void testselectByYS(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByYS();
        cars.forEach(car -> System.out.println(car));
    }


    @Test
    public void testselectTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long l = mapper.selectTotal();
        System.out.println(l);
        sqlSession.close();
    }


    @Test
    public void testinsertC(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.insertC(new Car(null, "9527", "问界M7", 50.39, "2023-10-15", "新能源"));
        System.out.println("成功插入了"+i+"条数据");
        sqlSession.commit();
        sqlSession.commit();
    }
}
