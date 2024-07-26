package com.powernode.bank.exceptions;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 9:16
 * @description:
 */
public class MoneyNotEnougthException extends Exception{
    public MoneyNotEnougthException() {
    }

    public MoneyNotEnougthException(String message) {
        super(message);
    }
}
