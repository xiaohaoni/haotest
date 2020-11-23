package com.hao.demo;

/**
 * 空值为参数是否会报错
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-17 19:35
 **/
public class NullDemo {

    public static void main(String[] args) {
        try {
            method02(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("这里");
    }

    public static void method01(Byte type, String param2) {
        String param1 = null;
        String param3 = null;
        if (type == 2) {
            param1 = "I";
            param3 = "you";
        }
        System.out.println(param1 + "," + param2 + "1" + param3);
    }

    public static void method02(Integer type) throws Exception {
        if (type == 1){
            throw new RuntimeException(" 这里里的异常");
        }if (type == 2){
            throw new RuntimeException(" 这里里的异常2");
        }
        System.out.println("到这里了");
    }


}
