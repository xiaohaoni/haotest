package com.hao.mode.factory.simplefactory.pizza;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:30
 **/
public class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给制作奶酪披萨，准备材料");
    }
}
