package com.soecode.lyf.testDemo.Listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by llh on 2018-02-03 11:45
 * 2.然后再创建一个监听类，
 * 相当于行人（不管是否使用交通工具），需要实现ApplicationListener接口，并且重写onApplicationEvent方法，
 * 可以理解成这个行人需要看信号灯，并且能理解信号灯的意思才行。否则不看信号灯跟没有信号灯没有区别，看了不理解也没用。
 */

@Component
public class ListenerTest1 implements ApplicationListener<EventTest> {

    @Override
    public void onApplicationEvent(EventTest event) {
        System.out.println("test1:" + event.getMessage());
    }
}