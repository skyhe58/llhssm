package com.soecode.lyf.aop.aop3;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

//后置通知
public class WelcomeAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置---welcome");
    }

}
