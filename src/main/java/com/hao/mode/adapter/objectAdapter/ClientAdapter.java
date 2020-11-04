package com.hao.mode.adapter.objectAdapter;

import java.util.PrimitiveIterator;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 22:03
 **/
public class ClientAdapter {
    public static void main(String[] args) {
        System.out.println("====类适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220()));
    }
}
