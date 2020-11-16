package com.hao.thread;

import org.springframework.util.StringUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁学习
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-11 15:35
 **/
public class LockTest {

    Lock lock = new ReentrantLock();
    String str  = null;
    /**
     *ReentrantLock，即 可重入锁。ReentrantLock是唯一实现了Lock接口的类，
     * 并且ReentrantLock提供了更多的方法。下面通过一些实例学习如何使用 ReentrantLock。
     *构造方法（不带参数 和带参数  true： 公平锁； false: 非公平锁）：
     */
    public void reentrantLockMethod(){

        // 获取锁
        lock.lock();
        try {
            if (StringUtils.isEmpty(str)){
                System.out.println(Thread.currentThread().getName() + " start get lock"+str);
                str = "我有值了";
            }
            // 访问此锁保护的资源
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            // 释放锁
            lock.unlock();
            System.out.println(" unlock ");
        }
        System.out.println(Thread.currentThread().getName() + " lose lock!");
        System.out.println(str);
    }
    public static void main(String[] args) {
        LockTest lt = new LockTest();
        for ( int i = 0;i <20 ;i++){
            new Thread(() -> lt.reentrantLockMethod()).start();
        }
    }
}
