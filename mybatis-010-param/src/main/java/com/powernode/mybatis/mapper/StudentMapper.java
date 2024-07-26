package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 杜嘉豪
 * @create 2024/4/11 11:50
 * @description:
 */
public interface StudentMapper {

    List<Student> slectById(Long id);

    List<Student> selectByName(String name);

    List<Student>  selectByBirth(Date birth);

    List<Student>  selectBySex(Character sex);

    int insertStudentByMap(Map<String, Object> map);

    int insertStudentByPojo(Student student);

    List<Student> selectByNameAndSex(String name,Character sex);

    List<Student> selectByNameAndSex2(@Param("name") String name,@Param("sex") Character sex );
}
