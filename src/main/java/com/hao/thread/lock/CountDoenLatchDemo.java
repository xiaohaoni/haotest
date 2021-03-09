package com.hao.thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-03-08 22:03
 **/
public class CountDoenLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"上午自习离开教室");
                latch.countDown();

            },String.valueOf(i)).start();

        }
        latch.await();
        System.out.println("班长锁门");
    }
}
