package com.hao.throwable;

import sun.tools.jar.Main;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-11 19:26
 **/
public class ExceptionTest {

    static public String exceptionMethod(){
        String str = "原值";
        try {
            int i = 1/0;
            str = "赋值了";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(exceptionMethod());
    }
}
