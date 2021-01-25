package com.hao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 16:05
 **/
public class ToStringUtlis {
    /**
     * organizationId=84C748FD-1F73-4A8F-A9D2-BFB43AC68D0C
     * organizationId=6863eb11-4c2d-4383-b375-acd739aaea2f
     * 原来：118673df928646c68983fe347f25a5a3
     */
    public static final String ORGANIZATION_RID = "c37134d28ddc426885303983e1197a83";

    public static final String GID = "32BAB824-392F-41AC-90BF-32217C743C7A";

    public static final String Tcm = "C33E7736-9FB3-4932-B4CC-030FAA76EBFC";


    /**
     * 月租卡A  开门卡 BBB817CE-E6A9-4F9C-8C2D-BDFD2431C053
     * C97611CE-C6EA-4582-9680-55934B79F9F7
     * */
    public static final  String TCMA = "C97611CE-C6EA-4582-9680-55934B79F9F7";

    public static String getUUIdToString() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
    public static String getUIdToString() {
        return UUID.randomUUID().toString();
    }

    public static String dateStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String dateLongStr(Long timeLong){
        Date date= new Date(timeLong);
        return dateStr(date);
    }
    public static Date stringDate(String dateStr){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("转化失败！");
        }
        return date;
    }

    public static void main(String[] args) {
        //晚归时间
        Calendar calendar = Calendar.getInstance();
       // int i = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(calendar.getWeekYear());
        System.out.println(calendar);

    }
}
