package com.hao.thread;

/**
 * 验证volatile可见性
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-24 23:06
 **/

public class VolatileDemo {
    public static void main(String[] args) {


    }
    /**
     * 代码验证原子性
     * */
    public void atomicity(){
        MyData myData = new MyData();
        for (int i = 0; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j <= 1000; j++) {
                    myData.add();
                }
                System.out.println(Thread.currentThread().getName() + "\t finally number " + myData.number);
            }, String.valueOf(i)).start();
        }
        //等待20个线程全部计算完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number " + myData.number);
    }

    /**
     * 保证可见性测试
     */
    public void visible() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ",come in");
            try {
                Thread.sleep(30000);
            } catch (Exception e) {

            }
            myData.addT60();
        }, "aaa").start();
        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "," + myData.number);
    }

}

class MyData {
     volatile int number = 0;

    public void addT60() {
        this.number = 60;
    }

    public void add() {
        number++;
    }
}
