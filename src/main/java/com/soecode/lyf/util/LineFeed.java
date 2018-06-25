package com.soecode.lyf.util;

/**
 * 英文语句断行不断单词
 *
 * Created by llh on 2018-06-25
 */
public class LineFeed {
    public String makelinefeed(String s) {
        //用空格作为分隔符，将单词存到字符数组里面
        String[] str = s.split(" ");
        //利用StringBuffer对字符串进行修改
        StringBuffer buffer = new StringBuffer();
        //判断单词长度，计算
        int len = 0;
        for (int i = 0; i < str.length; i++) {
            //System.out.println(str);
            //len = str[i].length();
            //叠加
            len += str[i].length();
            //System.out.println(len);
            if (len > 60) {
                buffer.append("\n" + str[i] + " ");//利用StringBuffer对字符串进行修改
//                len = str[i].length()+1;//+1为换行后读出空格一位
                len = str[i].length();//测试不需要+1
                //System.out.println(len);
            } else {
                buffer.append(str[i] + " ");
                len++;
                //System.out.println(len);
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        LineFeed lf = new LineFeed();
        System.out.println(lf.makelinefeed("The function returns the string, but with line breaks inserted at just the right places to make sure that no line is longer than the column number."));
    }
}
