package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utis.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 16:14
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testinsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"6666","丰田霸道",32.0,"2020-11-11","燃油车");
        mapper.insert(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testdeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteById(94l);
        System.out.println("删除了"+i+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testupdateCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car =new Car(64l,"1112","奔驰",19.12,"2022-10-16","燃油车");
        int i = mapper.updateCar(car);
        System.out.println("修改了"+i+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testselectByID(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByID(68l);
        System.out.println(car);
        sqlSession.close();
    }


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }



    @Test
    public void testselectCarByXml(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectCarByXml(67l);
        System.out.println(car);
        sqlSession.close();
    }


}
