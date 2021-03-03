package com.hao.java8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-28 22:51
 **/
public class Java8Demo {
    public static void main(String[] args) {
        Map map = new ConcurrentHashMap();
        map.put("a","a");
    }
}
