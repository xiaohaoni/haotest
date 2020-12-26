package com.hao.mode.strategy.pay;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:41
 * 上下文
 **/
public class PaymentContexts {
    private String userName = null;

    private  double money = 0.0;

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }

    private PaymentStrategy strategy = null;

    public PaymentContexts(String userName, double money, PaymentStrategy strategy) {
        this.userName = userName;
        this.money = money;
        this.strategy = strategy;
    }
    public void payNoe(){
        this.strategy.pay(this);
    }
}
