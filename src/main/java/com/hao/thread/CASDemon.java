package com.hao.thread;

import javax.smartcardio.ATR;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-25 22:59
 * 定义比较交换
 **/
public class CASDemon extends Thread {
    public static void main(String[] args) {
        /*AtomicInteger integer = new AtomicInteger(5);
        integer.getAndIncrement();
        integer.compareAndSet(5,100);*/
        System.out.println(CountryEnum.forEachCountryEnum(1).getValue());
    }
}
