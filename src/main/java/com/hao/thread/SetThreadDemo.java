package com.hao.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 14:00
 * set线程安全
 **/
public class SetThreadDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        for (int i = 0; i <= 30; i++) {
            //报:ConcurrentModificationException
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i).toString()).start();

        }
    }
}
