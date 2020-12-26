package com.hao.mode.strategy;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:29
 **/
public class OldCustomerStrategy implements Strategy{
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("老客户，统一打95折");
        return goodsPrice*0.95;
    }
}
