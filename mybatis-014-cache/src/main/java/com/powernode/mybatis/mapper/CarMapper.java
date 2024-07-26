package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

/**
 * @author 杜嘉豪
 * @create 2024/4/15 18:30
 * @description:
 */
public interface CarMapper {

    /**
     * 根据id返回car的汽车信息
     * @param id
     * @return
     */
    Car selectById(Long id);

    int insertClazz(@Param("cid") Integer cid, @Param("cname") String cname);


    /**
     * 测试二级缓存
     * @param id
     * @return
     */
    Car selectById2(Long id);
}
