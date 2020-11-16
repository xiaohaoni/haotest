package com.hao.mode.bridging;

/**
 * 具体实现类，以站内消息发送消息
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:04
 **/
public class MessageSMS implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内短信消息的方式，发送消息"+message+"给"+toUser);

    }
}
