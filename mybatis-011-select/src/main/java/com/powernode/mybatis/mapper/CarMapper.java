package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 杜嘉豪
 * @create 2024/4/12 8:31
 * @description:
 */
public interface CarMapper {

    Car  selectById(Long id);

    List<Car> selectAll();

    Car selectByBrandLike(String brand);


    /**
     * 根据id获取汽车信息，将汽车信息放到map集合当中
     * @param id
     * @return
     */
    Map<String,Object> selectByIdRetMap(Long id);

   List<Map<String,Object>> selectByIdRetMapAll();


    /**
     * 查询所有的Car,返回一个大Map集合
     * Map集合的key是每条记录的主键值
     * Map集合的value是每条记录
     * @return
     */
   @MapKey("id")  //将查询的结果的id值作为整个大Map集合的key
   Map<Long,Map<String,Object>> slectAllRetMap();



   Map<String,Object> selecttest(@Param("ce") Long id);


   List<Car> selectAllByResultMap();

   List<Car> selectByYS();


   Long selectTotal();


    /**
     *测试增加车辆
     * @return
     */
   int insertC(Car car);
}
