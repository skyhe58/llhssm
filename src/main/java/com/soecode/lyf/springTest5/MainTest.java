package com.soecode.lyf.springTest5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by llh on 2018-02-03 11:54
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest.class);
        EventPbulish eventPbulish = context.getBean(EventPbulish.class);
        eventPbulish.publish("zhangsan");
        context.close();
    }
}