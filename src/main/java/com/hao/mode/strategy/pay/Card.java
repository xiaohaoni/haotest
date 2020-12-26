package com.hao.mode.strategy.pay;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:56
 * 支付到银行卡
 **/
public class Card implements PaymentStrategy{
    @Override
    public void pay(PaymentContexts cox) {
        PaymentContexts2 contexts2 = (PaymentContexts2) cox;
        System.out.println("给"+contexts2.getUserName()+"的卡："+contexts2.getAccount()+"付了"+contexts2.getMoney());
    }
}
