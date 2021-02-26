package com.hao.demo.questions;

/**
 * 多线程刷图测试
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-21 14:14
 **/

public class Brounnd extends Thread {
    public static void main(String[] args) {
        int i = 0;
        i = i++ +i;
        System.out.println(i);
    }

    static int a = 12;

    @Override
    public void start() {
        for (int i = 1; i < 9; i++) {
            System.out.println(i);
        }
    }
}
