package com.soecode.lyf.testDemo.Listener;

import org.springframework.context.ApplicationEvent;

/**
 * 1.首先自定义一个事件，
 * 需要继承ApplicationEvent类，相当于安装了一个没有通电，没有灯光的信号灯，需要具有信号灯的基本特征。
 */
public class EventTest extends ApplicationEvent {

//    private static final long serialVersionUID = 1L;
    private String message;

    public EventTest(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}