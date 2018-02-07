package com.soecode.lyf.testDemo.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by llh on 2018-02-03 11:49
 * 3.这里的注解就只是简单的声明一个bean，应该不需要太多的解释。
 那么第三步自然是需要一个控制信号灯变化的东西，相当于是给他接好电线，给他一个正常变换红黄绿的程序和电路。
 */

@Component
public class EventPbulish {

    @Autowired
    ApplicationContext context;

    public void publish(String message) {
        context.publishEvent(new EventTest(this, message));
    }
}