package com.hao.jvm;

/**
 * 同步省略 锁消除
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-27 11:33
 **/
public class SunchronizedTest {
    /**
     * 同步省略 锁消除
     * */
    public void f(){
        Object obj = new Object();
        synchronized (obj){
            System.out.println(obj);
        }
    }
}
