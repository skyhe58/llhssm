package com.soecode.lyf.exception;

/**
 * Created by llh on 2018-01-22 16:28
 */
/**
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException{

    public NoNumberException(String message){
        super(message);
    }
    public NoNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}