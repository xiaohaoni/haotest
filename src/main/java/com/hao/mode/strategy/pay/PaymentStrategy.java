package com.hao.mode.strategy.pay;

/**
 * 工资不同的支付方式
 *策略接口
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:38
 **/
public interface PaymentStrategy {
    /**
     * 公司给某天政治支付工资
     *
     * @param cox 支付工资上下文，里面包含算法
     */
    public void pay(PaymentContexts cox);


}
