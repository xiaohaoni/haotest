package com.hao.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-22 15:49
 **/
public class ListDemo {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1);
        map.get(1);


    }

    public static List<Integer> res = new ArrayList<>();

    public static void calcul(int num) {
        double d = Math.log(num) / Math.log(2);
        int c = (int) Math.ceil(d);
        int f = (int) Math.floor(d);
        if (c == f || f == 0) {
            res.add(f + 1);
        } else {
            res.add(f + 1);
            int rest = (int) (num - Math.pow(2, f));
            calcul(rest);
        }
    }
}
