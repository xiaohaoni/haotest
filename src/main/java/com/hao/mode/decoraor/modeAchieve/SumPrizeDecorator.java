package com.hao.mode.decoraor.modeAchieve;


import java.util.Date;

/**
 * 装饰者模式
 * 装饰器对象，计算累计奖金
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 17:21
 **/
public class SumPrizeDecorator extends Decorator{
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c
     */
    public SumPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //1.先获取前面运输出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2.计算累计奖金，其实应按人员去获取累计的业务额，然后再乘以0.1%
        double prize = 1000000 * 0.001;
        System.out.println(user+"当月累计奖金"+prize);
        return money+prize;
    }
}
