package com.hao.mode.bridge;

/**
 * vivo手机
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 23:00
 **/
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}
