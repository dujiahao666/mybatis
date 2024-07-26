package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/13 17:09
 * @description:
 */
public interface CarMapper {

   Car selectById(Long id);


   List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);


   List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);


   List<Car> selectByMutiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

   int updateById(Car car);

   int updateBySet(Car car);


   List<Car>  selectByChoose(@Param("brand") String brand,@Param("guidePrice") Double guidePrice,@Param("carType") String carType);

   int deleteByid(String id);


   int deleteByIds(@Param("ids") Long[] ids);

   int insertBatch(@Param("cars") List<Car> cars);


   int deleteById2(@Param("ids") Long[] ids);
}
