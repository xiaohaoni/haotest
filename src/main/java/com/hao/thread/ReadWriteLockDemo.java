package com.hao.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-11 16:02
 * 独占锁
 * 总结：
 * 读-读可以共享
 * 读-写不能共存
 * 写-写不能共存
 **/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        myCache myCache = new myCache();
        //一共启动6个线程，3个读线程，3个写线程
        for (int i = 0; i <= 10; i++) {
            //启动1个读线程
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();

            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();

        }
    }
}

class myCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        try {
            rwLock.writeLock().lock();
            TimeUnit.MICROSECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：" + value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            rwLock.writeLock().unlock();

        }

    }

    public void get(String key) {
        try {
            rwLock.readLock().lock();
            TimeUnit.MICROSECONDS.sleep(300);
            System.out.println(Thread.currentThread().getName() + "\t 正在读取数据：" + key);
            Object object = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取数据完成：" + object);
        } catch (Exception e) {
        } finally {
            rwLock.readLock().unlock();
        }

    }

}
