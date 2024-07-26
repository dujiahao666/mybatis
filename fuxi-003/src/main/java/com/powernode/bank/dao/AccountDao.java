package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 8:50
 * @description:
 */
public interface AccountDao {
    Account selectByid(String id);
    int updateByActno(Account account);
}
