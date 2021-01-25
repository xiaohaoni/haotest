package com.hao.demo

import org.joda.time.DateTime

import java.sql.Time

/**
 *
 * 28800000
 *  ${description}*
 * @author zrh* @version 1.0* @date 2021-01-13 10:27 *  */
class TimeUtilsG {
    public static void main(String[] args) {
        Time time = new Time(1610523628000)
        println("time：" + time)
        println(new DateTime(time).millisOfDay)
        println(((new DateTime(time).millisOfDay - new DateTime().millisOfDay) / 60000))
        println("time："+new DateTime().withMillisOfDay(new DateTime(time).millisOfDay).millis)

    }
}
