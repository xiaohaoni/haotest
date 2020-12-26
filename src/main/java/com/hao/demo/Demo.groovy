package com.hao.demo

/**
 *
 *
 *  ${description}*
 * @author zrh* @version 1.0* @date 2020-12-24 19:47 * */
class Demo {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1);
        map.put(2,5);
        Integer count = map.get(1)+1;
        map.put(1,count)
        println(map.get(2))
    }
}
