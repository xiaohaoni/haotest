package com.hao.mode.decoraor.modeAchieve;

import com.hao.mode.decoraor.common.TempDB;

import java.util.Date;

/**
 * 装饰者模式
 * 装饰对象，计算当月业务奖金
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 17:15
 **/
public class MothPrizeDecorator extends Decorator {
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c
     */
    public MothPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //1.先获取前面运输出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2.计算当月业务奖金，按人员和时间去获取当月业务额，然后再乘以3%
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user+"当月业务奖金"+prize);
        return money+prize;

    }
}
