package com.hao.mode.flyweight;

/**
 * 享元模式
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-19 09:35
 **/
public interface Flyweight {
    /**
     * 判断传入得安全实体喝权限，是否喝享元对象内部匹配
     * @param securityEntity 安全实体
     * @param permit 权限
     * @return true /false
     * */
    public boolean match(String securityEntity,String permit);
}
