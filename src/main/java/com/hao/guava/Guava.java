package com.hao.guava;

import com.github.ltsopensource.core.commons.utils.StringUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-23 18:15
 **/
public class Guava {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(1,"zhu");
        AtomicInteger total = new AtomicInteger(0);
        total.getAndIncrement();
        System.out.println(total.get());
    }


    public void joiner() {
        List<String> list = new ArrayList<>();
        list.add("q");
        list.add("q");
        list.add("q");
        System.out.println(Joiner.on(",").join(list));
    }


    public static Multiset<Integer> getMultiset() {
        Multiset<Integer> multiset = HashMultiset.create();
        multiset.add(1);
        multiset.add(2);
        multiset.add(3);
        multiset.add(1);
        multiset.add(6);
        multiset.add(5);
        multiset.add(3);
        Iterator<Integer> iterator = multiset.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        System.out.println(multiset);
        return multiset;
    }

    public static Multimap<Integer, String> getMultimap() {
        Multimap<Integer, String> multimap = HashMultimap.create();
        multimap.put(1, "a");
        multimap.put(1, "b");
        multimap.put(2, "a");
        multimap.put(3, "a");
        Set<Integer> integerList = new HashSet<>(multimap.keys());

        System.out.println(integerList);
        return multimap;
    }

    /**
     * 根据ids字符串生成List<Long>
     *
     * @param ids
     * @return
     */
    static void idsString2LongList(String ids) {
        Iterable li = Splitter.on(",").trimResults().omitEmptyStrings().split(ids);


    }

    //Queue集合队列 先进先出
    public static void Test_queue() {
        String s = "我要去北京看故宫";
        String s1 = "我要去深圳吃龙虾";
        String s2 = "我要去四川吃麻辣烫";
        String s3 = "我要去西藏吃牛肉";
        String s4 = "我要去内蒙古骑马";

        Queue<String> qu = new LinkedList<>();
        qu.add(s);
        qu.add(s1);
        qu.add(s2);
        qu.add(s3);
        qu.add(s4);


        String str2 = qu.poll(); //弹出元素

        System.out.println(str2);


        System.out.println();

        qu.remove(s3);  //删除元素

        Iterator<String> it = qu.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }


    }


    static String list2String(List idList) {

        return Joiner.on(",").join(idList);


    }

}
