package com.hao.mode.decoraor.modeAchieve;

import com.hao.mode.decoraor.common.TempDB;

import java.util.Date;

/**
 * 装饰者模式
 * 装饰器对象，计算当月团队业务奖金
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 17:24
 **/
public class GroupPrizeDecorator extends Decorator {
    /**
     * 通过构造方法传入被装饰的对象
     *
     * @param c
     */
    public GroupPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //1.先获取前面运输出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2.然后计算当月团队业务奖金，先计算处团队总的业务额，然后再乘以1%
        //假设都是一个团队的
        double group = 0.0;
        for (double d : TempDB.mapMonthSaleMoney.values()) {
            group += d;
        }
        double prize = group * 0.01;

        System.out.println(user + "当月团队业务奖金" + prize);
        return money + prize;
    }
}
