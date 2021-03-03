package com.hao.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-27 15:57
 **/
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}

//资源类
class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    //健康
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //1,判断
            while (num != 0) {
                //等待,不生产 线程等待 o.wait()
                condition.await();
            }
            //2.加一
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1,判断
            while (num == 0) {
                //等待,不消费
                condition.await();
            }
            //2.减一
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}
