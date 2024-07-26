package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Log;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 17:17
 * @description:
 */
public interface LogMapper {

    List<Log> slectAllByTable(String date);
}
