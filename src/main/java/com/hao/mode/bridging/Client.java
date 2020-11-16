package com.hao.mode.bridging;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:17
 **/
public class Client {
    public static void main(String[] args) {
        //创建一个具体实现对象
        MessageImplementor implementor = new MessageSMS();
        AbstractMessage m = new CommonMessage(implementor);
        m.sendMessage("请喝茶","小李");
        m = new UrgencyMessage(implementor);
        m.sendMessage("请喝一杯茶","小李");
    }
}
