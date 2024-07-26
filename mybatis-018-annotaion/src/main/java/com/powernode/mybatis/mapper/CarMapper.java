package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 11:57
 * @description:
 */
public interface CarMapper {

    @Insert("insert into t_car values (null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})")
    int insert(Car car);


    @Delete("delete from t_Car where id=#{id}")
    int deleteById(@Param("id") Long id);


    @Update("update t_car set car_num=#{carNum},brand=#{brand},guide_price=#{guidePrice},produce_time=#{produceTime},car_type=#{carType} where id=#{id}")
    int updateCar(Car car);



    @Select("select  * from t_Car where id=#{id}")
    @Results({
            @Result(property ="id",column = "id"),
            @Result(property = "carNum",column = "car_num"),
            @Result(property = "brand",column = "brand"),
            @Result(property = "guidePrice",column = "guide_price"),
            @Result(property = "produceTime",column = "produce_time"),
            @Result(property = "carType",column = "car_type")
    })
    Car selectByID(Long id);


    @Select("select * from t_Car")
    List<Car> selectAll();



    Car selectCarByXml(Long id);
}
