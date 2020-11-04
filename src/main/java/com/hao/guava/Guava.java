package com.hao.guava;

import com.github.ltsopensource.core.commons.utils.StringUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.*;
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

    static String list2String(List idList) {

        return Joiner.on(",").join(idList);


    }

}
