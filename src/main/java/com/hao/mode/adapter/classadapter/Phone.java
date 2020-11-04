package com.hao.mode.adapter.classadapter;

/**
 * 手机类---充电
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 22:01
 **/
public class Phone {

    public void  charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.outPut5V() == 55){
            System.out.println("可以充电,v:55");
        }else {
            System.out.println("不可用充电v:220");
        }
    }
}
