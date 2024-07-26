package com.powernode.mybatis;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author 杜嘉豪
 * @create 2024/4/11 11:52
 * @description:
 */
public class StudentMapperTest {

    @Test
    public void testslectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.slectById(2L);
        students.stream().forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testselectByName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("张三");
        students.stream().forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testselectByBirth() throws Exception{
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = formatter.parse("2022-08-16");
        System.out.println(parse);
        List<Student> students = mapper.selectByBirth(parse);
        students.stream().forEach(student -> System.out.println(student));
        sqlSession.close();
    }


    @Test
    public void testselectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Character ch='男';
        Character ch = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(ch);
        students.stream().forEach(student -> System.out.println(student));
        sqlSession.close();
    }


    @Test
    public void testinsertStudentByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map=new HashMap<>();
        map.put("姓名","赵六");
        map.put("年龄",20);
        map.put("身高",1.81);
        map.put("性别",'男');
        map.put("生日",new Date());
        int i = mapper.insertStudentByMap(map);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }




    @Test
    public void testinsertStudentByPojo() throws Exception{
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("2023-10-01");
        Student student=new Student(null,"王麻子",21,1.82,parse,'男');
        int i = mapper.insertStudentByPojo(student);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testselectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张三", '男');
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }


    @Test
    public void testselectByNameAndSex2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //mapper实际上指向了代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //mapper是代理对象
        //selectByNameAndSex2是代理方法
        List<Student> students = mapper.selectByNameAndSex2( "张三",'男');
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
