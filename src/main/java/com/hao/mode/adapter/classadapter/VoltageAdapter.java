package com.hao.mode.adapter.classadapter;

/**
 * 类适配器
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:58
 **/
class VoltageAdapter extends Voltage220 implements IVoltage5V {

    @Override
    public int outPut5V() {
        System.out.println("输出电压5V");
        int v220 = outPull220V();
        int useV = v220/4;
        return useV;
    }
}
