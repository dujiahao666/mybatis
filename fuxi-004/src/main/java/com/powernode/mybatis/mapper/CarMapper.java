package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 14:50
 * @description:
 */
public interface CarMapper {
    int insert(Car car);

    int deleteByid(Long  id);

    int update(Car car);

    Car selectByid(Long id);

    List<Car> selectAll();

    List<Car> selectSome(@Param("a1") String bra, @Param("a2") Double gui);

    String slectBrand(Long id);
    Map<String, Objects> slectBrand2(Long id);

    @MapKey("id")
    Map<Long,Map<String,Object>> selectHaha();

    List<Car> selectOa(String name);

    List<Car> daba(@Param("a1") String brand,@Param("a2") String carType,@Param("@3") Double price);


    int updatetSet(Car car);

    List<Car> select6(@Param("brand") String brand,@Param("price") Double price, @Param("carType") String carType);


    int del(@Param("asds") Long[] args);

    List<Car> jicha();

    List<Car> jk(String brand);
}
