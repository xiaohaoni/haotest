package com.hao.util;

import org.joda.time.DateTime;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 10:43
 **/
public class TimeUtils {
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis();
        System.out.println(new DateTime(timeStamp).withMillisOfDay(0).getMillis());
        System.out.println(new DateTime(timeStamp).withMillisOfDay(0).plusDays(-1).getMillis());
    }

    /**
     *
     * @param plusDays timeStamp多几天 timeStamp时间就传0 -1比timeStamp减一天
     * @param timeStamp
     * @return
     */
    Long getInitialTime(int plusDays, Long timeStamp) {
        return new DateTime(timeStamp).withMillisOfDay(0).plusDays(plusDays).getMillis();
    }


}
