package com.hao.designPatterns.inPrinciple;

/**
 * 转换倒置原则
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-22 17:47
 **/
public class UpsideDown {
    public static void main(String[] args) {

    }
    interface IReceiver{
        public String getInfo();
    }
    class Email implements IReceiver{
        @Override
        public String getInfo() {
            return "电子信息发送";
        }
    }
    class Person{
        //对接依赖得接口
        public void  receive(IReceiver receiver){
            System.out.println(receiver.getInfo());
        }
    }
    //-------------------------依赖关心传递得关系---------------------------------
/**
 * 接口传递
 * */
}
