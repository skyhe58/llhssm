package com.soecode.lyf.test.regular;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by llh on 2017-11-27 09:50
 */
public class Test1Zz {

    private static final String REGEX = "\\[\\w+\\]";
    private static final String INPUT = "[awe564]";
    private static final String REGEXGET = "([a-zA-Z]+[\\d]+)";

    private static final String REGEX2 = "^\\{表[^x00-xff]*[\\d]}\\!\\[[a-zA-Z][\\d]\\]$";
    private static final String INPUT2 = "{表1}![w5]";
    private static final String REGEXGET2 = "^\\{([^x00-xff]+[\\d])}\\!\\[(\\w+)\\]$";


    private static final String REGEX3 = "^\\{[^x00-xff]+}\\!\\{表[^x00-xff]*[\\d]}\\!\\[[a-zA-Z][\\d]\\]$";
    private static final String INPUT3 = "{其他}!{表更多1}![c5]";
    private static final String REGEXGET3 = "^\\{([^x00-xff]+)}\\!\\{(表[^x00-xff]*[\\d])}\\!\\[([a-zA-Z][\\d])\\]$";

    public static void main(String[] args) {

//        regex1(REGEX,INPUT,REGEXGET);
//        regex2(REGEX2,INPUT2,REGEXGET2);
        regex3(REGEX3,INPUT3,REGEXGET3);

//        System.out.println(INPUT3.matches(REGEX3)?"true":"false");
//        Boolean isMatch = Pattern.matches(REGEX,INPUT);
//        System.out.println("------"+isMatch);

    }

//    @Test
//    public void regexTest(){
//        regex3(REGEX3,INPUT3,REGEXGET3);
//    }

    public static void regex3(String regex,String input,String regexget){
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(regexget);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(input);
        System.out.println(input.matches(regex)?"true":"false");
        if (m.find( )) {
            for(int i=1;i<=m.groupCount();i++) {
            System.out.println("Found value0: " + m.group(i));
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
            }
        } else {
            System.out.println("NO MATCH");
        }
    }

    public static void regex2(String regex,String input,String regexget){
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(regexget);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(input);
        System.out.println(input.matches(regex)?"true":"false");
        if (m.find( )) {
//            for(int i=0;i<m.groupCount();i++) {
              System.out.println("Found value0: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//            }
        } else {
            System.out.println("NO MATCH");
        }
    }

    public static void regex1(String regex,String input,String regexget){
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(regexget);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(input);
        System.out.println(input.matches(regex)?"true":"false");
        if (m.find( )) {
//            for(int i=0;i<m.groupCount();i++) {
//              System.out.println("Found value0: " + m.group(0));
                System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//            }
        } else {
            System.out.println("NO MATCH");
        }
    }
}
