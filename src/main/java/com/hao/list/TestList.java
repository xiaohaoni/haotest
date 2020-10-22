package com.hao.list;

import java.util.Calendar;
import java.util.Date;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-23 13:29
 **/
public class TestList {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 20);
        cal.set(Calendar.MINUTE, 40);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTime().getTime());
    }
}
