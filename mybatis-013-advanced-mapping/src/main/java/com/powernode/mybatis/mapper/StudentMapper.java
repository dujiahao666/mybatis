package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/14 22:43
 * @description:
 */
public interface StudentMapper {


    /**
     * 根据id获取学生信息，同时获取学生关联的班级信息
     *
     * @param id 学生的id
     * @return 学生对象，但是学生对象当中含有班级对象
     */
    Student selectById(Integer id);


    Student selectByIdAssociation(Integer id);

    Student selectByStep1(Integer id);

    List<Student> selectByCidstep2(Integer cid);
}
