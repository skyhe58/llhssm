package com.soecode.lyf.mianshi;

/**
 * equal:是用来比较两个对象内部的内容是否相等的，由于所有的类都是继承自java.lang.Object类的，所以如果没有对该方法进行覆盖的话，调用
 *的仍然是Object类中的方法，而Object中的equal方法返回的却是==的判断，因此，如果在没有进行该方法的覆盖后，调用该方法是没有
 *任何意义的。在java面向对象的处理中我们一般在javabean中都要选择重写equals方法，使用hibernate后，我们要生成数据库的映射文件与实体
 *类，这是我们就最好在实体类中进行equals方法的重写，重写时我们可以根据自己的定义来实现该方法只要遵守那五条原则，例如对于一个student类
 *
 * ==：是用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。
 *
 * @author llh @date 2018/6/26
 */
public class TestStringEqual {
    public static void main(String[] args) {
//        String str1 = "hello";
//        String str2 = "he" + new String("llo");
//        String str3 = "hel" + "lo";
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str1.equals(str2));

        System.out.println("=======================");
        String str1 = new String("str");
        String str2 = new String("str");
        System.out.println("==比较 ："+ (str1 == str2));
        System.out.println("equal比较："+ str1.equals(str2));
        String str3 = "str1";
        String str4 = "str1";
        System.out.println("==比较 ："+ (str3 == str4));
        System.out.println("equal比较："+ str3.equals(str4));
    }
}
