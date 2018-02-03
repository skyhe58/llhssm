package com.soecode.lyf.aop.aop4;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by llh on 2018-02-01 13:47
 */
public class SomeServiceImpl implements ISomeService{

    @Override
    public void doSome() throws SomeException, OtherException {
        System.out.println("SomeServiceImpl.doSome()");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        if(n==1){
            throw new SomeException();
        }
        if(n==2){
            throw new OtherException();
        }
    }
}
