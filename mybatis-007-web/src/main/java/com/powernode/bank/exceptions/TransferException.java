package com.powernode.bank.exceptions;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 17:01
 * @description:
 */
public class TransferException extends Exception{
    public TransferException() {
    }

    public TransferException(String msg) {
        super(msg);
    }
}
