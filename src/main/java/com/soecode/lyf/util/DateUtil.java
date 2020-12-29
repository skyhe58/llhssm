package com.soecode.lyf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    /**
     * 获取对应年份的生日时间
     *
     * @param birthDate
     * @param comparisonDate
     * @return 如入参（01-04，2020-12-29），出参：2020-01-04
     */
    public static LocalDateTime calculateTime(LocalDate birthDate, LocalDate comparisonDate) {
        LocalDate localDate = comparisonDate.withMonth(birthDate.getMonthValue()).withDayOfMonth(birthDate.getDayOfMonth());
        //得到给定年的生日
        return localDate.atStartOfDay();
    }

    /**
     * 把时间指定为 00:00
     *
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getCurrentSpecifiedTime(LocalDateTime localDateTime) {
        return localDateTime.withMinute(0).withSecond(0);
    }

    /**
     * 获取前几天或者后几天时间 前几天- 后几天 +
     *
     * @return
     */
    public static String getYesterdayString(int day) {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    /**
     * 获取前几天或者后几天时间 前几天- 后几天 +
     *
     * @return
     */
    public static Date getDay(int day) {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取前几分钟或者后几分钟时间 前几分钟- 后几分钟 +
     *
     * @param minute
     * @return
     */
    public static LocalDateTime getNowAfterMinute(int minute) {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);//把日期往前减少多少分钟，若想把日期向后推多少分钟则将负数改为正数
        date = calendar.getTime();
        return date2LocalDate(date);
    }

    /**
     * Date转LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime date2LocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    /**
     * 两段时间是否存在交集
     * true存在交集  false不存在交集
     *
     * @return
     */
    public static boolean isIntersect(LocalDateTime startA, LocalDateTime endA, LocalDateTime startB, LocalDateTime endB) {
        return !notIntersect(startA, endA, startB, endB);
    }

    /**
     * 两段时间是否无交集
     * true无交集  false存在交集
     * <p>
     * 调用方法时，确保 time1A 必须 time1B之前， 确保 time2C 必须 time2D之前
     *
     * @param time1A 1号时间段开始端
     * @param time1B 1号时间段结束端
     * @param time2C 2号时间段开始端
     * @param time2D 2号时间段结束端
     * @return
     */
    public static boolean notIntersect(LocalDateTime time1A, LocalDateTime time1B, LocalDateTime time2C, LocalDateTime time2D) {
        if (time1A.isAfter(time2D) || time2C.isAfter(time1B)) {
            return true;
        }
        return false;
    }

    public static LocalDate getStringToDate(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, fmt);
    }

    public static LocalDateTime getStringToDateTime(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, fmt);
    }

    public static LocalDateTime getStringToDateTimeD(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM月dd日 HH:mm");
        return LocalDateTime.parse(date, fmt);
    }

    public static String getLocalDateToString(LocalDate localDate) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(fmt);
    }

    public static String getLocalDateToSString(LocalDateTime localDateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(fmt);
    }

    public static LocalDateTime getString2Time(String date) {
        if (null == date || "".equals(date)) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, df);
    }

    /**
     * 获取这天时间的最大时间 2020-07-01 23:59:59
     *
     * @param time
     * @return
     */
    public static LocalDateTime getMaxDate(LocalDateTime time) {
        if (null != time) {
            return time.withHour(23).withMinute(59).withSecond(59);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(StringToDate("2017-09-21 11:44:50"));

    }

}
