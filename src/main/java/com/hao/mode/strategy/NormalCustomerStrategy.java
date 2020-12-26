package com.hao.mode.strategy;

/**
 * 具体的算法实现
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:28
 **/
public class NormalCustomerStrategy implements Strategy{
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于新用户或者普通用户没有折扣");
        return goodsPrice;
    }

}
