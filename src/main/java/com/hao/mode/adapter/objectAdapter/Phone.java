package com.hao.mode.adapter.objectAdapter;

/**
 * 手机类---充电
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 22:01
 **/
public class Phone {

    public void  charging(IVoltage5V iVoltage5V){
        int i = iVoltage5V.outPut5V();
        if (i== 5){
            System.out.println("可以充电,v:"+i);
        }else {
            System.out.println("不可用充电v:"+i);
        }
    }
}
