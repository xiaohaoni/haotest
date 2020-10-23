package com.hao.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-22 15:49
 **/
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(2));
    }
}
