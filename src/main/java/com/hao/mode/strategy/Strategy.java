package com.hao.mode.strategy;

/**
 * 策略，定义计算报价孙发的接口
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:25
 **/
public interface Strategy {
    /**
     * 算法接口
     * @param goodsPrice  商品价钱
     * */
    public  double calcPrice(double goodsPrice);
}
