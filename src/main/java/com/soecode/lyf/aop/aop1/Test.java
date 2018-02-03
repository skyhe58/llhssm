package com.soecode.lyf.aop.aop1;

//静态代理
public class Test {
    public static void main(String[] args) {
        ISomeService someService = new SomeServiceProxy();

        someService.doSome();
        someService.doOther();
    }

}
