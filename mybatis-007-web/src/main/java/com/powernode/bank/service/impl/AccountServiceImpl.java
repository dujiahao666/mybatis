package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.utils.GenerateDaoProxy;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 15:47
 * @description:
 */
public class AccountServiceImpl implements AccountService {
    //    private AccountDao accountDao = new AccountDaoImpl();
//    private AccountDao accountDao= (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);
// private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);
// private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        //添加事物控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //1.判断转出账户余额是否充足（select)
        Account fromAct = accountDao.selectByActno(fromActno);
        //2.如果转出账户余额不足，提示用户
        if (fromAct.getBalance() < money) {
            System.out.println("账户余额不足");
            throw new MoneyNotEnoughException("账户余额不足！");
            //如果这里出错了，程序到这里就结束了
        }
        //3.如果转出账户余额充足，更新转出账户余额(update)
        //更新内存
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //4.更新转入账户余额(update)
        //更新数据库
        int count = accountDao.updateByActno(fromAct);
        /*String str=null;
        System.out.println(str.toString());*/
        count += accountDao.updateByActno(toAct);
        if (count != 2) {
            throw new TransferException("转账异常，未知原因woc！");
        }
        //提交事务
        sqlSession.commit();
        //关闭事物
        SqlSessionUtil.close(sqlSession);


    }
}
