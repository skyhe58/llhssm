package com.soecode.lyf.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigdecimalTest {

    @Test
    public void test(){
        // TODO Auto-generated method stub
        System.out.println(new BigDecimal("123.4", new MathContext(4,
                RoundingMode.HALF_UP)));
        System.out.println(new BigDecimal("123.4", new MathContext(2,
                RoundingMode.HALF_UP)));
        System.out.println(new BigDecimal("123.4", new MathContext(2,
                RoundingMode.CEILING)));
        System.out.println(new BigDecimal("123.4", new MathContext(1,
                RoundingMode.CEILING)));
        System.out.println(new BigDecimal("-0.000104", new MathContext(1,
                RoundingMode.CEILING)));

        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(3);
        BigDecimal c = a.divide(b,new MathContext(6));
//                .setScale(6, BigDecimal.ROUND_HALF_UP);
        System.out.println(": " + c);

//        1178.7-1178.70000041   , 92515.295778-92515.29580091
        BigDecimal d1 = new BigDecimal("8.7").setScale(8,RoundingMode.HALF_UP);
        BigDecimal d2 = new BigDecimal("8.70000041").setScale(8,RoundingMode.HALF_UP);
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
        //当小数达到8位，且只有末尾有数字（少于等于2个非零数字）时会内部转换科学计数，需要将类型转换成String
        BigDecimal d = d1.subtract(d2);
        System.out.println("d: " + d);

//        BigDecimal f1 = new BigDecimal("92515.295778").setScale(8,RoundingMode.HALF_UP);
//        BigDecimal f2 = new BigDecimal("92515.29580091").setScale(8,RoundingMode.HALF_UP);
//        System.out.println("f1: " + f1);
//        System.out.println("f2: " + f2);
//        BigDecimal f = f1.subtract(f2);
//        System.out.println("f: " + f);

//        System.out.println("====" + BigDecimal.valueOf(-41, 8));

    }

    /**
     * 千分位
     */
    @Test
    public void test2(){
        //1.创建数字格式化对象
        //需求：加入千分位.
        DecimalFormat df = new DecimalFormat("###,###");
        //开始格式化
        System.out.println(df.format(1234567)); //"1,234,567"

        //需求：加入千分位，保留2位小数
        DecimalFormat df1 = new DecimalFormat("###,###.##");
        System.out.println(df1.format(1234567.123)); //"1,234,567.12"

        //需求：加入千分位，保留4位小数，并且不够补0
        DecimalFormat df2 = new DecimalFormat("###,###.0000");
        System.out.println(df2.format(1234567.123));//"1,234,567.1230"



        //创建大数据.
        BigDecimal v1 = new BigDecimal(10);
        BigDecimal v2 = new BigDecimal(20);
        //做加法运算
        //v1 + v2; //错误:两个引用类型不能做加法运算.
        //必须调用方法执行加法运算.
        BigDecimal v3 = v1.add(v2);
        System.out.println(v3); //30
    }
}
