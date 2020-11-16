package com.hao.mode.bridging;

/**
 * c抽象的消息对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:00
 **/
public abstract class AbstractMessage {

    /**
     * 抽象的消息对象
     *
     * */
    protected MessageImplementor implementor;

    /**
     * 构造方法
     * */
    public AbstractMessage(MessageImplementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 发送消息，转调实现部分的方法
     *
     * */
    public void sendMessage(String message,String toUser){
        this.implementor.send(message,toUser);
    }
}
