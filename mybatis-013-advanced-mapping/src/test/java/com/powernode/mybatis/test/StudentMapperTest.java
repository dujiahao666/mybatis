package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/14 22:48
 * @description:
 */
public class StudentMapperTest {

    @Test
    public void testselectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student.getClazz().getCname());
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testselectByIdAssociation() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(2);
        System.out.println("==============");
        System.out.println(student.getClazz().getCname());
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testselectByStep1(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByStep1(5);
//        System.out.println(student);
        System.out.println(student.getSid());
//        System.out.println(student.getClazz().getCname());
        sqlSession.close();
    }


    @Test
    public void testselectByCidstep2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByCidstep2(1000);
        System.out.println(students);
        sqlSession.close();
    }
}
