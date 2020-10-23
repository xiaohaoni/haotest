package com.hao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 18:15
 **/
public class guava {
    public static void main(String[] args) {
        Multimap<Integer,String> multimap = HashMultimap.create();
        multimap.put(1,"a");
        multimap.put(1,"b");
        multimap.put(2,"a");
        multimap.put(3,"a");
       System.out.println(multimap.get(1));
    }

}
