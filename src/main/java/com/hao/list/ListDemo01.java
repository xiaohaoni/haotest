package com.hao.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-01-22 17:27
 **/
public class ListDemo01 {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        int  count = 0;
        int count2 = 0;
        for (int i = 0; i < 40; i++) {
            if (count == i){
                count2 ++;
                list.add(count2);
            }
            count++;
        }
        System.out.println(System.currentTimeMillis() - startTime+"count:"+count+",count2:"+count2);
    }
}
