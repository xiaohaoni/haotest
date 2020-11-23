package com.hao.mode.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-19 09:43
 **/
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();
    private  FlyweightFactory(){}

    public static FlyweightFactory getInstance(){
        return  factory;
    }

    /**
     * 缓存多个flyweight对象
     * */
    private Map<String,Flyweight> fsMap = new HashMap<String,Flyweight>();

    /**
     * 获取key对应的享元对象
     *
     * */
    public Flyweight getFlyweight(String key){
        Flyweight f = fsMap.get(key);
        if (f == null){
            f = new AuthorizationFlyweight(key);
            fsMap.put(key,f);
        }
        return  f;
    }
}
