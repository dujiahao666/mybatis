package com.powernode.bank.exceptions;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 9:25
 * @description:
 */
public class TransferException extends Exception{
    public TransferException() {
    }

    public TransferException(String message) {
        super(message);
    }
}
