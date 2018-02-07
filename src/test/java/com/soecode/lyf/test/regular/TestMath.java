package com.soecode.lyf.test.regular;

/**
 * Created by llh on 2018-01-03 19:41
 */
public class TestMath {
    public static void main(String[] args) {
//        double[] nums = { 1.4, 1.5, 1.6, -1.4, -1.5, -1.6 };
        double[] nums = { 1.0,1.4, 1.5};
        for (double num : nums) {
            test(num);
        }
    }

    private static void test(double num) {
        System.out.println("1--Math.floor(" + num + ")=" + Math.floor(num));
        System.out.println("2--Math.round(" + num + ")=" + Math.round(num));
        System.out.println("3--Math.ceil(" + num + ")=" + Math.ceil(num));
    }
}
