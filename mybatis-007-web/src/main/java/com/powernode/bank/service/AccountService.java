package com.powernode.bank.service;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 15:44
 * @description:账户业务类
 * 注意：业务类当中的业务方法的名字在起名字的时候，最好见名之意，能够体现出业务具体是干什么的
 */
public interface AccountService {

 /**
  *
  * @param fromActno 转出账号
  * @param toActno  转入账号
  * @param money  转账金额
  */
  public void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
