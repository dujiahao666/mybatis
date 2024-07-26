package com.powernode.bank.exceptions;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 16:40
 * @description:余额不足异常
 */
public class MoneyNotEnoughException extends Exception {
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
