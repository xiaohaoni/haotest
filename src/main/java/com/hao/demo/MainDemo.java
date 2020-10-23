package com.hao.demo;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-07-21 16:45
 **/
public class MainDemo {


    public static void main(String[] args) {

        String str = "SI0000091";
        String idStr = str.replaceFirst("SI", "0");
        long l = Long.parseLong(idStr);
        System.out.println(l);

    }
}
