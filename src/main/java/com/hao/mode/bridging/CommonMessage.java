package com.hao.mode.bridging;

/**
 * 普通消息的实现
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:07
 **/
public class CommonMessage extends AbstractMessage{
    /**
     * 构造方法
     *
     * @param implementor
     */
    public CommonMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String toUser){
        //对于普通消息，什么都不干，直接调用父类的方法，吧消息发送出去就可以了
        super.sendMessage(message,toUser);
    }
}
