package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 8:41
 * @description:
 */
public interface CarMapper {

    /**
     * 分页茶轩
     * @param startIndex 起始下标
     * @param pageSize    每页显示的记录条数
     * @return
     */
    List<Car> selectByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


    /**
     * 查询所有的Car,通过分页查询插件PageHelper
     * @return
     */
    List<Car> selectAll();
}
