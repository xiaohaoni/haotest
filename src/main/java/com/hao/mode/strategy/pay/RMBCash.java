package com.hao.mode.strategy.pay;

/**
 * 人民币支付方式
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:42
 **/
public class RMBCash implements PaymentStrategy{
    @Override
    public void pay(PaymentContexts cox) {
        System.out.println("人民币支付方式算法"+cox.getUserName()+"付了"+cox.getMoney());
    }
}
