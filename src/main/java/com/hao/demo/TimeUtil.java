package com.hao.demo;

import sun.tools.jar.Main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-07-24 16:09
 **/
public class TimeUtil {
    public static void main(String[] args) {
        List<String> monthList = new ArrayList<>();
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        int nowMoth = date.get(Calendar.MONTH)+1;
        for (int i = 0; i < 6; i++) {
            int moth = nowMoth - i;
            String time = year+"/"+moth;
            monthList.add(time) ;
        }
        for (String str:monthList){
            System.out.println(str);
        }
    }


}
