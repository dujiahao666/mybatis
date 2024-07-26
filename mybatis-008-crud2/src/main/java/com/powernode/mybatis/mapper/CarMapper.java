package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 8:46
 * @description:
 */
public interface CarMapper {
    int insert23(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();


    List<Car> ca(Long id,double pirc);
}
