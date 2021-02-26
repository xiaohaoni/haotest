package com.hao.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 14:07
 **/
public class MapThreadDemo {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i <= 30; i++) {
            //报:ConcurrentModificationException
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0, 8),"d");
                System.out.println(map);
            }, String.valueOf(i).toString()).start();

        }
        for(String key : map.keySet()){
            System.out.println(key);
        }
        //value
        for(String value : map.values()){
            System.out.println(value);
        }

        for(Map.Entry<String, String> entry : map.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }

    }
}
