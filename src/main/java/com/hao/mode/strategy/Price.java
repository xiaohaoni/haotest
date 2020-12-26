package com.hao.mode.strategy;

/**
 * 价格管理
 * 上下文
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:31
 **/
public class Price {
    /**
     * 持有一个策略
     * */
    private  Strategy strategy = null;

    public Price(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 对具体的客户报价
     * */
    public double quote(double goodsPrice){
        return this.strategy.calcPrice(goodsPrice);
    }
}
