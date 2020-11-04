package com.hao.mode.factory.absfactory.order;



/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:31
 * 客户端
 **/
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());

    }
}
