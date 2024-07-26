package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 9:17
 * @description:
 */
public class CarMapperTest {

    @Test
    public void test1(){
        /**
         * @Autowild
         * CarMapper carMapper;
         * carMapper.selectById();
         */
    }

    @Test
    public void testinsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面相接口获取的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(null,"8564","凯美瑞你好",3.0,"2020-10-10","新能源");
        int insert = mapper.insert23(car);  //实际调用的就是下面的,但是在项目里面还省略了SqlSession sqlSession=SqlSessionUtil.openSession();
        System.out.println(insert);  //跟项目相关 ！！！





       /* System.out.println("==========");
        int insert1 = sqlSession.insert("insert", car); //项目无关，测试用
        System.out.println("=====");*/

        sqlSession.commit();



    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int i = mapper.deleteById(54L);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car=new Car(1L,"8564","我错了，把你的所有都变了",3.0,"2020-10-10","新能源");
        int update = mapper.update(car);
        System.out.println("改变了"+update+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectone(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(1l);
        System.out.println(car);
    }

    @Test
    public void testSelectAll(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }


    @Test
    public void  ccc()throws Exception{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> ca = mapper.ca(20l, 21.98);
        for (Car car : ca) {
            System.out.println(car);
        }
        sqlSession.close();
       /* List<Car> cars = sqlSession.selectList("ccca", 20);
        for (Car car : cars) {
            System.out.println(car);
        }
        sqlSession.close();*/
    }
}
