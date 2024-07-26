package com.powernode.bank.service;

import com.powernode.bank.exceptions.MoneyNotEnougthException;
import com.powernode.bank.exceptions.TransferException;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 8:39
 * @description:
 */
public interface AccountService {
    public void transfer(String fromActno,String toActno,double money) throws MoneyNotEnougthException, TransferException;
}
