package com.soecode.lyf.aop3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

//环绕通知
public class TimeAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object target=invocation.getThis();
        Method method=invocation.getMethod();
        Object[] args=invocation.getArguments();

        Object returnValue=null;
        long start=0;
        long end=0;
        try {
            System.out.println("开始");
            start=System.currentTimeMillis();

            returnValue = invocation.proceed();

            end=System.currentTimeMillis();
            System.out.println("结束");
            System.out.println(method.getName()+" "+(end-start));
        } catch (Exception e) {
            end=System.currentTimeMillis();
            System.out.println("出错");
            System.out.println(method.getName()+" "+(end-start));
            throw e;
        }

        return returnValue;
    }

}
