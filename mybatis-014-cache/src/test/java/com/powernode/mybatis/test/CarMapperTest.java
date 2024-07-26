package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @create 2024/4/15 18:34
 * @description:
 */
public class CarMapperTest {

    @Test
    public void testSelectById() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

//        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession1.getMapper(CarMapper.class);
        Car car = mapper.selectById(59l);
        System.out.println(car);

        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(59l);
        System.out.println(car1);

       /* SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(59l);
        System.out.println(car2);*/

        sqlSession1.close();
//        sqlSession2.close();
    }

    @Test
    public void testSelectById2() throws Exception {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(59l);
        System.out.println(car);
//        sqlSession.clearCache();
        mapper.insertClazz(6666, "测试boss");
        Car car2 = mapper.selectById(59l);
        System.out.println(car2);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testselectById2() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);

        Car car1 = mapper1.selectById2(59l);
        System.out.println(car1);
        sqlSession1.close();
        //如果这里不关闭Sqlsession1对象的话，二级缓存中还是没有数据的
        Car car2 = mapper2.selectById2(59l);
        System.out.println(car2);

//        sqlSession1.close();
        sqlSession2.close();
    }






}
