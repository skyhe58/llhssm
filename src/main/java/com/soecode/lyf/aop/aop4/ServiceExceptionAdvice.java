package com.soecode.lyf.aop.aop4;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by llh on 2018-02-01 13:53
 */
//异常通知
public class ServiceExceptionAdvice implements ThrowsAdvice {
//    public void afterThrow(Exception ex){
//        System.out.println("exception");
//    }

    public void afterThrowing(Method method,Object[] args,Object target,Exception ex){
        System.out.println(target.getClass().getName()+"类"+method.getName()+"方法抛出"+ex+"异常");
    }
}
