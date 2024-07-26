package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

/**
 * @author 杜嘉豪
 * @create 2024/4/14 22:42
 * @description:
 */
public interface ClazzMapper {
    Clazz selectByid(Integer id);

    Clazz selectByCollection(Integer cid);


    Clazz selectBystep1(Integer id);



}
