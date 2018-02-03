package com.soecode.lyf.aop.aop2;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.util.Date;

//动态代理模式
public class Test {
    public static void main(String[] args) {
        ISomeService someService = (ISomeService)Proxy.newProxyInstance(
                SomeServiceImpl.class.getClassLoader(),
                SomeServiceImpl.class.getInterfaces(),
                new LogInvocationHandler(new SomeServiceImpl())
        );
        System.out.println(someService.getClass());
        someService.doSome();
        someService.doOther();
        someService.f();
    }
}

class LogInvocationHandler implements  InvocationHandler{

    private Object target;

    public LogInvocationHandler(Object target){
        super();
        this.target = target;
    }

    /*
	 * proxy	代理对象
	 * method	目标方法
	 * args		方法参数
	 *
	 * 方法执行的结果
	 */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"方法在"+new Date()+"执行了");
        return method.invoke(target,args);
    }
}