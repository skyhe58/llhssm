package com.soecode.lyf.exception;

/**
 * Created by llh on 2018-01-22 16:28
 */
/**
 * 预约业务异常
 */
public class AppointException extends RuntimeException{
    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
