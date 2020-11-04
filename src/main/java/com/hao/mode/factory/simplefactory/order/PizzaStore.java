package com.hao.mode.factory.simplefactory.order;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:31
 * 客户端
 **/
public class PizzaStore {
    public static void main(String[] args) {
      /*  new OrderPizza(new SimpleFactory());
        System.out.println("退出");*/
        new OrderPizza2().setFactory();
        System.out.println("退出");

    }
}
