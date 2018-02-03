package com.soecode.lyf.aop.aop2;

public class SomeServiceImpl implements ISomeService{
    @Override
    public void doOther() {
        System.out.println("SomeServiceImpl.doOther()");
    }

    @Override
    public void doSome() {
        System.out.println("SomeServiceImpl.doSome()");
    }

    @Override
    public void f() {
        System.out.println("SomeServiceImpl.f()");
    }
}
