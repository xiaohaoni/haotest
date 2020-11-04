package com.hao.mode.bridge;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 23:09
 **/
public class Client {
    public static void main(String[] args) {
        Phone phone = new FoldedPhone(new XiaoMi());
        phone.open();
    }
}
