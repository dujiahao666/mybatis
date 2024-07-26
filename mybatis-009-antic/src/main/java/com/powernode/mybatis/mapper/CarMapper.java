package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 15:58
 * @description:
 */
public interface CarMapper {

    List<Car> selectByCarType(String carType);


    List<Car> selectAllByAscOrDesc(String ascOrDesc);

    int insertCar(Car car);


    int deleteBatch(String ids);


    List<Car> selectByBrandLike(String brand);

    int insertCarUseGeneratedKeys(Car car);
}
