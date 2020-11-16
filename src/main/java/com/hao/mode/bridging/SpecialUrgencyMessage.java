package com.hao.mode.bridging;

/**
 * 新的功能 特急
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:15
 **/
public class SpecialUrgencyMessage extends AbstractMessage{
    /**
     * 构造方法
     *
     * @param implementor
     */
    public SpecialUrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    /**
     * 催促功能
     * */
    public void hurry(String messageId){
        System.out.println("特急消息发送催促功能");
    }

    @Override
    public void sendMessage(String message, String toUser){
        //加急消息
        message = "特急"+message;
        super.sendMessage(message,toUser);
    }
}
