package com.soecode.lyf.exception;

/**
 * Created by llh on 2018-01-22 16:28
 */
/**
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException{
    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
