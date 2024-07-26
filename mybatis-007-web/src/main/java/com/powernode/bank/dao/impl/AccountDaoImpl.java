package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 16:02
 * @description:
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account)sqlSession.selectOne("com.powernode.bank.dao.AccountDao.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count =  sqlSession.update("com.powernode.bank.dao.AccountDao.updateByActno", act);
        return count;
    }
}
