package com.hao.util;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 10:43
 **/
public class TimeUtils {
    public static void main(String[] args) {
        try {
            strFromDate();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * @param plusDays  timeStamp多几天 timeStamp时间就传0 -1比timeStamp减一天
     * @param timeStamp
     * @return
     */
    Long getInitialTime(int plusDays, Long timeStamp) {
        return new DateTime(timeStamp).withMillisOfDay(0).plusDays(plusDays).getMillis();
    }

    /***/
    static void strFromDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:H");
        Date date = simpleDateFormat.parse("2021-02-26:01");
        //Mon Sep 02 00:00:00 CST 2019
        System.out.println(date);
        //2019-09-02
        System.out.println(simpleDateFormat.format(date));
        System.out.println(date.getTime());
    }


}
