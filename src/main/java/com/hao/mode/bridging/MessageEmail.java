package com.hao.mode.bridging;

/**
 * 用e-main打方式发送消息
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:06
 **/
public class MessageEmail implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用Email消息的方式，发送消息"+message+"给"+toUser);
    }
}
