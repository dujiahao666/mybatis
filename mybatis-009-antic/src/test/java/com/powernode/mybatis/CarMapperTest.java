package com.powernode.mybatis;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 16:15
 * @description:
 */
public class CarMapperTest {

    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //mapper实际上就是daoImpl对象
        //底层不但为CarMapper接口生成了字节码，并且还new实现类对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("新能源");
        cars.forEach(car -> System.out.println(car));
    }


    @Test
    public void testselectAllByAscOrDesc(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByAscOrDesc("desc");
        cars.forEach(car -> System.out.println(car));
    }


    @Test
    public void testInsertCar(){
        Car car=new Car(null,"11111","奔驰",21.92,"2024-04-09","燃油车");

        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.insertCar(car);
        if(i>0){
            System.out.println("成功插入数据!");
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testdeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("56,57,58");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
     public void testselectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("奔驰");
        cars.forEach(car -> System.out.println(car));
    }


    @Test
    public void testinsertCarUseGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"123","懒散哥",21.23,"2024-04-11","新能源");
        int i = mapper.insertCarUseGeneratedKeys(car);
        System.out.println("成功插入"+i+"条数据");
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }}
