package com.soecode.lyf.test.regular;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by llh on 2018-01-03
 */
public class Test4Zz {
    private static final String INPUT1333=  "MAX(RPT_ZB('A102010一般企业成本支出明细表','A102010一般企业成本支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('BA102020金融企业支出明细表','A102020金融企业支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('CA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C22')+RPT_ZB('DA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C23')+RPT_ZB('EA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C24')+RPT_ZB('FA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C25'),RPT_ZB('GA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C28')+RPT_ZB('HA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C24')+RPT_ZB('IA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C25')+RPT_ZB('JA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C26')+RPT_ZB('KA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C27')+RPT_ZB('LA103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C28'))";

    private static final String REGEX1 = "\\),";

    private static final String INPUT1 =  "MAX(RPT_ZB('A102010一般企业成本支出明细表','A102010一般企业成本支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('A102020金融企业支出明细表','A102020金融企业支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'))";
//    private static final String INPUT1 = "MAX(RPT_ZB('A102010一般企业成本支出明细表','A102010一般企业成本支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('A102020金融企业支出明细表','A102020金融企业支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C4'),RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C22')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C23')" ;
//        "+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C24')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C25'),RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C28')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C24')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C25')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C26')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C27')+RPT_ZB('A103000事业单位、民间非营利组织收入、支出明细表','A103000事业单位、民间非营利组织收入、支出明细表',$ZTDM$,$KJND$,$KJQJ$,'C28'))";

    public static void main(String[] args) {
//        regex1(REGEX1,INPUT1);
        final String regEx = "(10*?)";
        String s = "10001";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        if(mat.find()){
            for(int i=1;i<=mat.groupCount();i++){
                System.out.println(mat.group(i));
            }
        }else{
            System.out.println("null-------");
        }


    }

    public static void regex1(String regex,String input){
        Pattern p = Pattern.compile(regex);
        // 获取 matcher 对象
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
//            m.appendReplacement(sb,"-");
            for(int i=0;i<=m.groupCount();i++) {
                System.out.println("Found value" + i + ": " + m.group(i));
            }
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

}
