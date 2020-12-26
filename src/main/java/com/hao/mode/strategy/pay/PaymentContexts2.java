package com.hao.mode.strategy.pay;

/**
 * 扩展上下午
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:53
 **/
public class PaymentContexts2 extends PaymentContexts {
    /*
     * 银行账号
     * */
    private String account = null;

    public String getAccount() {
        return account;
    }

    public PaymentContexts2(String userName, double money, String account, PaymentStrategy strategy) {
        super(userName, money, strategy);
        this.account =account;
    }
}
