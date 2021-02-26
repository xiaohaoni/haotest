package com.hao.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子操作
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-26 09:48
 **/
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("zs",22);
        User li4 = new User("ls",23);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4)+","+atomicReference.toString());
        System.out.println(atomicReference.compareAndSet(z3, li4)+","+atomicReference.toString());
    }
}

@Getter
@ToString
@AllArgsConstructor
class User{
    String userName;
    int age;
}
