package com.soecode.lyf.test.utilTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";
    public static final String NORM_TIME_PATTERN = "HH:mm:ss";
    public static final String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getFullDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(NORM_DATETIME_PATTERN);
        return sdf.format(date);
    }

    public static Date StringToDate(String context) {
        SimpleDateFormat sdf = new SimpleDateFormat(NORM_DATETIME_PATTERN);
        try {
            return sdf.parse(context);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(StringToDate("2017-09-21 11:44:50"));

    }

}
