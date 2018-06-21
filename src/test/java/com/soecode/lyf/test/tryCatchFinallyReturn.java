package com.soecode.lyf.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 总结测试：
 * 1、finally语句总会执行
 * 2、如果try、catch中有return语句，finally中没有return，那么在finally中修改除包装类型和静态变量、
 *    全局变量以外的数据都不会对try、catch中返回的变量有任何的影响（包装类型、静态变量会改变、全局变量）
 * 3、尽量不要在finally中使用return语句，如果使用的话，会忽略try、catch中的返回语句，也会忽略try、catch中的异常，屏蔽了错误的发生
 * 4、finally中避免再次抛出异常，一旦finally中发生异常，代码执行将会抛出finally中的异常信息，try、catch中的异常将被忽略
 * 所以在实际项目中，finally常常是用来关闭流或者数据库资源的，并不额外做其他操作。
 *
 */
public class tryCatchFinallyReturn {
    public static void main(String[] args) {
        int i;
//        i = testBasic1();
//        i = testBasic2();
//        i = testBasic4();
        i = testBasic5();
//        i = testBasic6();
        System.out.println("main  = "+i);

//        List list = new ArrayList();
//        list = testWrap();
//        list.forEach(bean -> System.out.println("main  list ="+bean));
    }

    public static int testBasic1(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i);
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
        }
        return i;
    }

    /**
     * 把return语句放入try catch里
     *
     * 代码顺序执行从try到finally，由于finally是无论如何都会执行的，所以try里的语句并不会直接返回。
     * 在try语句的return块中，return返回的引用变量并不是try语句外定义的引用变量i,而是系统重新定义了一个局部引用i’，
     * 这个引用指向了引用i对应的值，也就是2，即使在finally语句中把引用i指向了值10，因为return返回的引用已经不是i,而是i',
     * 所以引用i的值和try语句中的返回值无关了。
     * @return
     */
    public static  int testBasic2(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
        }
    }


    /**
     * 把i换成包装类型而不是基本类型
     *
     *可以看到，finally里对list集合的操作生效了，这是为什么呢。我们知道基本类型在栈中存储，
     *而对于非基本类型是存储在堆中的，返回的是堆中的地址，因此内容被改变了。
     * @return
     */
    public static List<Object> testWrap(){
        List<Object> list = new ArrayList<>();
        try{
            list.add("try");
            System.out.println("try block");
            return list;
        }catch(Exception e){
            list.add("catch");
            System.out.println("catch block");
            return list;
        }finally{
            list.add("finally");
            System.out.println("finally block ");
        }
    }


    /**
     * 在finally里加一个return
     *
     * 可以看到，是从finally语句块中返回的。可见，JVM是忽略了try中的return语句。
     * 但IDE中会对finally中加的return有黄色警告提示
     * @return
     */
    public static  int testBasic4(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
            return i;
        }
    }


    /**
     * 在try里加入一行会执行异常的代码
     *
     * 可以看到，因为finally中有return语句，try、catch中的异常被消化掉了，屏蔽了异常的发生，
     * 这与初期使用try、catch的初衷是相违背的，因此编译器也会提示警告。
     * @return
     */
    public static  int testBasic5(){
        int i = 1;
        try{
            i++;
            int m = i / 0 ;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i +", e="+e);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
            return i;
        }
    }


    /**
     * 如果在finally中有异常发生，会对try、catch中的异常有什么影响呢
     *
     * 这个提示表示的是finally里的异常信息，也就是说一旦finally里发生异常，try、catch里的异常信息即被消化掉了，
     * 也达不到异常信息处理的目的。
     * @return
     */
    public static  int testBasic6(){
        int i = 1;
        try{
            i++;
            Integer.parseInt(null);
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            String.valueOf(null);
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            int m = i / 0;
            System.out.println("finally block i = "+i);
        }
    }

}
