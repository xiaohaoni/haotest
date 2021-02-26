package com.hao.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 12:21
 * ABA解决方案
 **/
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("=============ABA产生============");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);

        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());


        }, "t2").start();

        System.out.println("=============ABA解决============");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"\t 第一次版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),stamp+1);
            System.out.println(Thread.currentThread().getName() +"\t 第二次次版本号"+stamp);
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),stamp+1);
            System.out.println(Thread.currentThread().getName() +"\t 第三次版本号"+stamp);
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"\t 第四次版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 1200, stamp, stamp + 1));
            System.out.println(Thread.currentThread().getName() +"\t 第四次版本号"+stamp+",最终值："+atomicStampedReference.getReference());


        }, "t4").start();



    }
}
