package com.hao.jvm;

import java.io.Serializable;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-09-27 16:10
 * 方法区
 **/
public class MethodTest extends Object implements Comparable<String>,Serializable {
    @Override
    public int compareTo(String o) {
        return 0;
    }
    public int num = 1;
    public static  String str = "hao";
    public void method01(){
        int count = 1;
    }
    public static int method02(int cal){
        int result = 0;
        try {
            int value = 30;
            result = value/result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
