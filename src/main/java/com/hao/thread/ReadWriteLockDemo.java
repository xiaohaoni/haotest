package com.hao.thread;

import java.util.Random;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-11 16:02
 **/
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        final Queue queue = new Queue();
        //一共启动6个线程，3个读线程，3个写线程
        for (int i = 0; i < 3; i++) {
            //启动1个读线程
            new Thread() {
                public void run() {
                    while (true) {
                        queue.get();
                    }
                }

            }.start();
            //启动1个写线程
            new Thread() {
                public void run() {
                    while (true) {
                        queue.put(new Random().nextInt(10000));
                    }
                }
            }.start();
        }
    }
}
