package com.soecode.lyf.test;

import com.soecode.lyf.entity.Book;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;

/**
 * Created by llh on 2018-06-05
 */
public class Test {
    @org.junit.Test
    public void test1() {
        Book book = new Book();
        if (Optional.ofNullable(book).isPresent()) {
            System.out.println("----====");
        }
    }

    /**引用，值传递*/
    @org.junit.Test
    public void Test2() {
        Person zhangsan = new Person("ZHANG San");
        changePerson(zhangsan);
        zhangsan.printName();
    }
    public void changePerson(Person person) {
        person = new Person("LI Si");
    }
    class Person {
        String name = "default";

        public Person(String name) {
            this.name = name;
        }

        public void changeName(String name) {
            this.name = name;
        }

        void printName() {
            System.out.println(this.name);
        }
    }

    @org.junit.Test
    public  void Test3() {
        Test t = new Test();
        int a=99;
        t.test1(a);//这里传递的参数a就是按值传递
        System.out.println("1 a="+a);

        MyObj obj=new MyObj();
        t.test2(obj);//这里传递的参数obj就是引用传递
        System.out.println("1 b="+obj.b);
    }

    public void test1(int a){
        a=++a;
        System.out.println("2 a="+a);
    }

    public void test2(MyObj obj){
        obj.b=100;
        System.out.println("2 b="+obj.b);
    }
    class MyObj{
        public int b=99;
    }

    @org.junit.Test
    public void testQfw(){
        BigDecimal a = new BigDecimal("0.00");
        DecimalFormat df = new DecimalFormat("###,###.00");
        String str = df.format(a);

        str = str.replaceAll("^[.]", "0.");
        str = str.replaceAll("[.]$", ".00");
        System.out.println("---- " + str);

        String stra = "aa啊KCaa";
        float mcLength = null == stra ? 0 : stra.toLowerCase().getBytes().length;
        float ggxhLength = null == "" ? 0 : "".getBytes().length;

        float strLength = 0f;
        for (int i = 0; i < stra.length(); i++) {
            char c = stra.charAt(i);
            if (!Character.isLowerCase(c)&&!Character.isUpperCase(c)) {
                strLength = strLength + 2;
            } else if(Character.isUpperCase(c)){
                //页面测试一个大写大约等于1.54个小写字母占的空间
                strLength = strLength + 1.6f;
            }else if(Character.isLowerCase(c)){
                strLength = strLength + 1;
            }
        }
        System.out.println("======= "+ strLength);

        //字符所占行数
        int rows = (int) (Math.ceil(mcLength / 30) > Math.ceil(ggxhLength / 20) ? Math.ceil(mcLength / 30) : Math.ceil(ggxhLength / 20));
        System.out.println("---"+rows);
        }

}
