package com.hao.thread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 增加一定值才能往下走
 *
 * @author zrh
 * @version 1.0
 * @date 2021-03-08 22:10
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception{
        CyclicBarrier barrier = new CyclicBarrier(7,()->{
            System.out.println("以集齐");
        });
        for (int i = 0;i< 8;i++){
            int temp  = i;
            new Thread(()->{
                System.out.println("第+"+temp+"颗");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }
    }
}

