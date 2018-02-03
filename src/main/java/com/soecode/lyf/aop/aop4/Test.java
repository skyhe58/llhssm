package com.soecode.lyf.aop.aop4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by llh on 2018-02-01 14:36
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "aop4/applicationContext.xml");
        ISomeService someService = (ISomeService) ac.getBean("someService");
        try {
            someService.doSome();
        } catch (SomeException e) {
            System.out.println("main SomeException");
        } catch (OtherException e) {
            System.out.println("main OtherException");
        }
    }
}
