package com.hao.logdemo.async;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-09-15 11:48
 **/
public class AsyncMain {

    public static void main(String[] args) {
        AsyncDemo asyncDemo = new AsyncDemo();
        int total = 20;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < total; i++) {
            asyncDemo.asynMethod();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        for (int i = 1; i < total; i++) {
            asyncDemo.haoMethod();
        }
        long end2Time = System.currentTimeMillis();
        System.out.println(end2Time - endTime);
    }
}
