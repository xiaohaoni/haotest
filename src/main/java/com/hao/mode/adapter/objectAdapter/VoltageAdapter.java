package com.hao.mode.adapter.objectAdapter;

/**
 * 类适配器
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:58
 **/
class VoltageAdapter implements IVoltage5V {
    /**
     * 聚合关系
     * */
    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int outPut5V() {
        System.out.println("输出电压5V");
        int dst = 0;
        if (voltage220 != null){
            int src = voltage220.outPull220V();
            System.out.println("使用类适配器，进行转换");
            dst = src/44;
            System.out.println("适配完成，输出电压："+dst);
        }
        return dst;
    }
}
