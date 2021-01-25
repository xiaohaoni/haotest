package com.hao.demo;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-07-24 16:09
 **/
public class TimeUtil {


    private void getMe() {

        List<String> monthList = new ArrayList<>();
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        int nowMoth = date.get(Calendar.MONTH) + 1;
        for (int i = 0; i < 6; i++) {
            int moth = nowMoth - i;
            String time = year + "/" + moth;
            monthList.add(time);
        }
        for (String str : monthList) {
            System.out.println(str);
        }
    }

    /**/
    private static void getOneDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        System.out.println(cal.getTime());
    }

    /**
     * 获取当月的第一天
     */
    static Date getFirstDayOfMonthDate(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        //设置每月的最小天数
        //cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DAY_OF_MONTH));
        //设置每天的最小小时
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        //设置每小时最小分钟
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        //设置每分钟最小秒
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        System.out.println(cal.getTime());
        System.out.println(cal.getTimeInMillis());
        return cal.getTime();
    }

    //12000000
    public static void main(String[] args) {
        System.out.println(new DateTime().getMillisOfDay());

    }


    public static Integer square(Integer num, Integer weekIds) {
        while (true) {
            num++;
            weekIds = weekIds / 2;
        }

    }

    public void dayTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(cal.getTimeInMillis());
    }

    /**
     * 获取周几
     */
    public static void getWeekIdx() {
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = "周日";
        } else if (weekday == 2) {
            week = "周一";
        } else if (weekday == 3) {
            week = "周二";
        } else if (weekday == 4) {
            week = "周三";
        } else if (weekday == 5) {
            week = "周四";
        } else if (weekday == 6) {
            week = "周五";
        } else if (weekday == 7) {
            week = "周六";
        }
        System.out.println(week);
    }

    /**
     * 获取当前月第一天
     *
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        // 设置月份
        calendar.set(Calendar.MONTH, month - 1);
        // 获取某月最小天数
        int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        calendar.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDay1 = sdf.format(calendar.getTime()) + " 00:00:00";
        return firstDay1;
    }


    public static String getLastDayOfMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        // 设置月份
        calendar.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = 0;
        //2月的平年瑞年天数
        if (month == 2) {
            lastDay = calendar.getLeastMaximum(Calendar.DAY_OF_MONTH);
        } else {
            lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        // 设置日历中月份的最大天数
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDay1 = sdf.format(calendar.getTime()) + " 23:59:59";
        return lastDay1;
    }

    /**
     * 获取当月的最后一天
     */
    static Date getLastDayOfMonthDate(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        //设置每月的最大天数
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        //设置每天的最大小时
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        //设置每小时最大分钟
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        //设置每分钟最大秒
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        System.out.println(cal.getTime());
        System.out.println(cal.getTimeInMillis());
        cal.getTime();
        return cal.getTime();
    }

}
