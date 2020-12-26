package com.hao.mode.strategy.pay;

/**
 * 美元支付方式
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:45
 **/
public class
DollarCash implements PaymentStrategy{
    @Override
    public void pay(PaymentContexts cox) {
        System.out.println("美元支付方式"+cox.getUserName()+"支付了"+cox.getMoney());
    }
}
