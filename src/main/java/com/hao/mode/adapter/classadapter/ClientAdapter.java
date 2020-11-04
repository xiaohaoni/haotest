package com.hao.mode.adapter.classadapter;

import org.springframework.security.core.parameters.P;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 22:03
 **/
public class ClientAdapter {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
