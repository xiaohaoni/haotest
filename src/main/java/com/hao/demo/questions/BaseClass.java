package com.hao.demo.questions;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-25 16:56
 **/
public class BaseClass {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        integer.getAndIncrement();
        System.out.println(integer);
    }
}
