package com.hao.mode.bridging;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 19:55
 * 实现发送信息的统一接口
 **/
public interface MessageImplementor {

    /**
     * 发送消息
     * @param message 消息内容
     * @param toUser 发给谁
     * */
    public void send(String message,String toUser);
}
