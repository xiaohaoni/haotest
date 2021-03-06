package com.hao.thread.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 23:12
 * 自旋锁
 **/
public class spinLockDemo {
    static AtomicReference atomicReference = new AtomicReference();

    //锁
    public static void myMock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come on");
        while (!atomicReference.compareAndSet(null, thread)) {

        }

    }

    //释放锁
    static public void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "\t unlock");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            myMock();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
            unLock();
        }, "AA").start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        new Thread(() -> {
            myMock();
            System.out.println("B获取锁");
            unLock();
        }, "BB").start();

    }
}
