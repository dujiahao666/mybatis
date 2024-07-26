package com.powernode.bank.service.Impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.Impl.AccountDaoImpl;
import com.powernode.bank.exceptions.MoneyNotEnougthException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 8:41
 * @description:
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao=new AccountDaoImpl();
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnougthException, TransferException {
        //查询账户余额
        Account account1 = accountDao.selectByid(fromActno);
        if(account1.getBalance() < money){
            throw  new MoneyNotEnougthException("对不起，余额不足！");
        }

        Account account2 = accountDao.selectByid(toActno);
        account1.setBalance(account1.getBalance()-money);
        account2.setBalance(account2.getBalance()+money);

        //调用dao层代码，先进行金额相减去
        int accout = accountDao.updateByActno(account1);
        accout+=accountDao.updateByActno(account2);
        if(accout!=2){
            throw new TransferException("转账异常，请联系柜台人员");
        }

    }

}
