package com.hao.logdemo.async;

import org.springframework.scheduling.annotation.Async;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-15 11:44
 **/
public class AsyncDemo {

    public void haoMethod(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("普通方法");
    }

    @Async
    public void asynMethod(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步方法");
    }
}
