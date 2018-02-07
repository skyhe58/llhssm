package com.soecode.lyf.testDemo;

/**
 * Created by llh on 2018-02-06 16:22
 */
//解决循环依赖
public class  solveXhylTest{
    public static void main(String[] args) {
        A testa = new A();
        B testb = new B();
        testa.b = testb;
        testb.a = testa;
        testa.printB();
        testb.printA();
        testa.print();
        testb.print();
    }
}

class A{
    public B b;
    public void printB(){
        b.printB();
    }

    public void printA(){
        System.out.println("AA");
    }

    public void print(){
        b.printA();
    }
}
class B{
    public A a;
    public void printB(){
        System.out.println("BB");
    }

    public void printA(){
        a.printA();
    }
    public void print(){
        a.printB();
    }
}

/**
 *循环依赖问题
 *如果此时我们运行该类的话，会报如下错误：Exception in thread "main" java.lang.StackOverflowError
 */
/*
public class  xhylTest{
    public static void main(String[] args) {
        B testb = new B();
    }
}

class A{
    public B b;
    public A (){
        b = new B();
    }
    public void printB(){
        System.out.println("Ab");
        b.printA();
    }

    public void printA(){
        System.out.println("AA");
    }
　　　}

class B{
    public A a;
    public B (){
        a = new A();
    }
    public void printB(){
        System.out.println("BB");
        a.printA();
    }

    public void printA(){
        a.printA();
    }
　　　}*/
