package com.hao.mode.strategy;

import sun.tools.jar.Main;

/**
 * 客户端
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:34
 **/
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new OldCustomerStrategy();
        Price price = new Price(strategy);
        Double goodsPrice = price.quote(1000);

        System.out.println(goodsPrice);
    }
}
