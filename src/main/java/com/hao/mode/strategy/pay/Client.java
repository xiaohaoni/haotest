package com.hao.mode.strategy.pay;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-28 15:48
 **/
public class Client {
    public static void main(String[] args) {
        PaymentStrategy rmbStrategy = new RMBCash();
        PaymentStrategy  dollarStrategy= new DollarCash();
        PaymentContexts contextsX = new PaymentContexts("小李",1000.0,rmbStrategy);
        contextsX.payNoe();
        //扩展上下文
        PaymentStrategy cardStrategy = new Card();
        PaymentContexts contxt2 =  new PaymentContexts2("小李",1000.0,"431241441",rmbStrategy);
        contxt2.payNoe();
    }
}
