package com.powernode.bank.dao.Impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 8:52
 * @description:
 */
public class AccountDaoImpl implements AccountDao {
    private static SqlSessionFactory builder;

    static {
        try {
            builder = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Account selectByid(String id) {
        SqlSession sqlSession = builder.openSession();
        Account account = sqlSession.selectOne("selectByid", id);
        return account;
    }

    @Override
    public int updateByActno(Account account) {
        SqlSession sqlSession = builder.openSession();
        int update = sqlSession.update("updateByActno", account);
        sqlSession.commit();
        sqlSession.close();
        return update;

    }


}
