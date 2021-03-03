package com.hao.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-27 14:14
 * 阻塞队列
 **/
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put3");
                blockingQueue.put("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "aa").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t 取值" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t 取值" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t 取值" + blockingQueue.take());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "bb").start();
    }

    /**
     * 队列满了会直接抛出异常
     */
    public static void ArrayBlockingQueue() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
    }

    /**
     * 生产一个拿一个，没有容器，
     * */
    public static void SynchronousQueue() {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put3");
                blockingQueue.put("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "aa").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t 取值" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t 取值" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t 取值" + blockingQueue.take());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "bb").start();
    }
}
