package com.hao.demo.questions;

/**
 * @author zrh
 * @version 1.0
 * @date 2021-02-25 13:43
 **/
public class Child extends Person{
    public static void main(String[] args) {
        InterfaceDemo i = new InterfaceDemo() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }
}
