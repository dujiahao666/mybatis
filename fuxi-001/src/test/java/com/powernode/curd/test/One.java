package com.powernode.curd.test;

import com.powernode.curd.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 16:38
 * @description:
 */
public class One {
    @Test
    public void testOpenSession(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int insert = sqlSession.insert("ok1");
        System.out.println(insert);
        Logger logger = LoggerFactory.getLogger(One.class);
        logger.info("改变成功");
        sqlSession.commit();
    }
}
