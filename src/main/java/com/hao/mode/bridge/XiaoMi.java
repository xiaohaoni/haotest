package com.hao.mode.bridge;

/**
 * 小米手机
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 22:59
 **/
public class XiaoMi implements Brand{
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
