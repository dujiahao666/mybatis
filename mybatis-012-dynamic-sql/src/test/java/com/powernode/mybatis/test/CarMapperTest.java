package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/13 17:12
 * @description:
 */

public class CarMapperTest {

    @Test
    public void testselectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(2l);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testselectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //三个参数的类型
        List<Car> cars = mapper.selectByMultiCondition("比亚迪",2.00,"新能源");


        //假设三个参数都是空
        //List<Car> cars = mapper.selectByMultiCondition("", null, "");

        //假设后两个条件不为空，第一个条件为空
//        List<Car> cars = mapper.selectByMultiCondition("", 2.0, "新能源");

        //假设第一个条件不是空，后两个条件是空
        //List<Car> cars = mapper.selectByMultiCondition("比亚迪", null, "");


        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }



    @Test
    public void testselectByMultiConditionWithWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //三个条件都不为空
        List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪", 2.0, "新能源");

        //三个条件都是空
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, null);

        //如果第一个条件是空
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 2.0, "新能源");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }


    @Test
    public void testselectByMutiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);


//        List<Car> cars = mapper.selectByMutiConditionWithTrim(null, null, "");
//        List<Car> cars = mapper.selectByMutiConditionWithTrim("比亚迪", null, "");
        List<Car> cars = mapper.selectByMutiConditionWithTrim("比亚迪", null, "");

        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }



    @Test
    public void testupdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.updateById(new Car(67l,null,"改装车",null,null,"燃油车"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testupdateBySet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.updateBySet(new Car(67l,null,"改装车3",null,null,"新能源"));
//        int i = mapper.updateBySet(new Car(null,null,null,null,null,null));
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testselectByChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByChoose(null, null, null);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }



    @Test
    public void testdeleteByid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteByid("81,82");
        System.out.println("删除了"+i+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testdeleteByIds(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] args={90l,89l};
        int i = mapper.deleteByIds(args);
        System.out.println("成功删除了"+i+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testinsertBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list=new ArrayList<>();
        list.add(new Car(101l,"1023","大众",12.36,"2024-4-16","新能源"));
        list.add(new Car(102l,"1023","大众",12.36,"2024-4-16","新能源"));
        list.add(new Car(103l,"1023","大众",12.36,"2024-4-16","新能源"));
        int i = mapper.insertBatch(list);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testdeleteById2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] list={91l,92l,93l};
        int i = mapper.deleteById2(list);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

}
