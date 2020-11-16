package com.hao.mode.bridging;

/**
 * 加急消息
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-15 20:11
 **/
public class UrgencyMessage extends AbstractMessage{
    /**
     * 构造方法
     *
     * @param implementor
     */
    public UrgencyMessage(MessageImplementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(String message, String toUser){
        //加急消息
        message = "加急"+message;
        super.sendMessage(message,toUser);
    }

    /**
     * 扩展自己的新功能
     * */
    public Object watch(String messageId){
        //获取相应的数据，组织乘嘉能可的数据对象，然后返回
        return  null;
    }


}
