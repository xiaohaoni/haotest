package com.hao.demo.questions;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-23 21:16
 **/
public class ArraryDemon extends Date {

    public static void main(String[] args) {
        Map map = new HashMap();
        Map courrMap = new ConcurrentHashMap();
        courrMap.put("b",1);
        map.put("a",1);

    }

    public void superMethod() {
        System.out.println(super.getClass().getName());

    }

    /*
     * //d ds
     * */
    public void arrayMethod() {
        int[] x = new int[10];
        System.out.println(x[9]);

    }
}
