package com.soecode.lyf.test.regular;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by llh on 2018-01-03
 */
public class Test3Zz {

//    private static final String REGEX2 = "RPT_ZB\\(.*\\),+?RPT_ZB\\(.*\\)";
//    private static final String REGEX1 = "((RPT_ZB\\(.*\\),)+|(RPT_ZB\\(.*\\))+|(RPT_ZB\\(.*\\)\\+))+";
//    private static final String REGEX1 = "(RPT_ZB\\('\\w*[\\u4e00-\\u9fa5]*'\\))*)";
    private static final String REGEX1 = "(RPT_ZB\\(.*\\).*?)";
    private static final String INPUT1 =  "MAX(RPT_ZB('swafs') + RPT_ZB('qweqqqqq'))";
//    private static final String INPUT1 =  "MAX(RPT_ZB('A102010一般企业成本支出明细表','A102010一般企业成本支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('A102020金融企业支出明细表','A102020金融企业支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C22')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C23')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C24')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C25')    ,RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C28')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C24')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C25')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C26')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C27')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C28'))";

    public static void main(String[] args) {
        regex1(REGEX1,INPUT1);

    }

    public static void regex1(String regex,String input){
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(regex);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(input);
//        System.out.println(input.matches(regex)?"true":"false");
        while (m.find()) {
            System.out.println(m.group(1));
        }
//         while(m.find( )) {
////            for(int i=0;i<=m.groupCount();i++) {
//                System.out.println("Found value" + ": " + m.group(1));
//////            System.out.println("Found value: " + m.group(1));
//////            System.out.println("Found value: " + m.group(2) );
////            }
////            String str = m.group(0);
////            //对表达式进分组重用
////            String ragex1="(\\),|)+\\)";
////            String[] ss = str.split(ragex1);
////            for(String st:ss){
////                System.out.println("-----"+st+")");
////            }
//        }
////        else {
////            System.out.println("NO MATCH");
////        }
    }
}
