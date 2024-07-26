package com.powernode.test;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/1 21:02
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        HashMap<String,Object> map=new HashMap<>();
        map.put("car_num","1023");
        map.put("brand","比亚迪.汉");
        map.put("guide_price",14.69);
        map.put("produce_time","2022-10-19");
        map.put("car_type","新能源");
        sqlSession.insert("insertCar",map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //执行的语句
        Car car=new Car(null,"1024","小米suv7",21.59,"2024-3-28","新能源");
        int insertPojo = sqlSession.insert("insertPojo", car);
        System.out.println("插入"+insertPojo+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testdelepojo(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int delepojo = sqlSession.delete("delepojo","37");  //这里底层给的是object类型，所以我们这里用数字的数字还是这个字符串的数字都是可以的，不用深究，但是还是数字更好啦
        System.out.println("成功删除一条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateByid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car=new Car(4l,"9999","凯美瑞",30.3,"2000-10-22","燃油车");
        int updateByid = sqlSession.update("updateByid", car);
        System.out.println("修改"+updateByid+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testselectByid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object o = sqlSession.selectOne("selectByid", 44);
        System.out.println(o);
        sqlSession.close();
    }

    @Test
    public void testselectByall(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> objects = sqlSession.selectList("selectByall");
        objects.forEach(s-> System.out.println(s));
        sqlSession.close();
    }

    @Test
    public void testNameSpace(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> objects = sqlSession.selectList("aaaaaa.selectByall");
        objects.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
}
