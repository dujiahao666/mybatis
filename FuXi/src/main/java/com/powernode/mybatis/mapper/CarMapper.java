package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/4/23 0:43
 * @description:
 */
public interface CarMapper {
    Car selectById(Long id);
}
