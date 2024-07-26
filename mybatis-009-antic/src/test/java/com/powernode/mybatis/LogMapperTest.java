package com.powernode.mybatis;

import com.powernode.mybatis.mapper.LogMapper;
import com.powernode.mybatis.pojo.Log;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 17:19
 * @description:
 */
public class LogMapperTest {

    @Test
    public void testslectAllByTable(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs = mapper.slectAllByTable("20220902");
        logs.forEach(log -> System.out.println(log));
    }

}
