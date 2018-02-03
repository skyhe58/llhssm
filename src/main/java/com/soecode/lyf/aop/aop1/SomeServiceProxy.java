package com.soecode.lyf.aop.aop1;

import java.util.Date;

public class SomeServiceProxy implements  ISomeService{

    private ISomeService someService;

    public SomeServiceProxy(){
        someService = new SomeServiceImpl();
    }

    @Override
    public void doOther() {
        System.out.println("doOther execute at:"+new Date());
        someService.doOther();
    }

    @Override
    public void doSome() {
        System.out.println("doSome execute at:"+new Date());
        someService.doSome();
    }
}
