package com.hao.mode.factory;

import java.util.Calendar;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 17:22
 **/
public class CalendarFactory {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getWeekYear());
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println();
    }
}
