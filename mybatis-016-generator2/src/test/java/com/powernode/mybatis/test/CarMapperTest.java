package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.CarExample;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/15 23:50
 * @description:
 */
public class CarMapperTest {

    //CarExample类负责封装查询条件的
    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //查询一个
        //Car car = mapper.selectByPrimaryKey(59l);
        //System.out.println(car);

        //查询所有
        //List<Car> cars = mapper.selectByExample(null);
        //cars.forEach(car1 -> System.out.println(car1));

        //根据条件进行查询
        CarExample carExample=new CarExample();
//        carExample.or().andCarTypeEqualTo("燃油车").andProduceTimeGreaterThan("2024-01-01");;
        carExample.createCriteria().andBrandLike("奔").andGuidePriceGreaterThan(new BigDecimal(23.5));
        carExample.or().andProduceTimeGreaterThan("2024-01-01");

        List<Car> cars = mapper.selectByExample(carExample);
        cars.forEach(car -> System.out.println(car));

        sqlSession.close();
    }

}
