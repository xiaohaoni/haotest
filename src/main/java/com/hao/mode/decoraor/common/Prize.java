package com.hao.mode.decoraor.common;

import java.util.Date;

/**
 * 奖金计算对象
 * 计算规则：
 * 每个人当月业务奖金=当月销售额*3%
 * 每个人累计奖金 = 总的回款额 * 0.1%
 * 团队奖金=团队总销售额 *1%
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-06 15:57
 **/
public class Prize {

    public double calcPrize(String user, Date begin, Date end) {
        double prize = 0.0;
        //计算当月业务奖金，所有人都会计算
        prize = this.monthPrize(user, begin, end);
        //计算累计奖金
        prize += this.sumPrize(user, begin, end);
        //需要判断该人员是普通人员还是业务经理
        if (this.isManager(user)) {
            prize += this.groupPrize(user, begin, end);
        }
        return prize;
    }

    /**
     * 计算某人的当月业务奖金
     */
    private double monthPrize(String user, Date begin, Date end) {
        //计算当月业务奖金，按照人员去获取当月的业务额
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金" + prize);
        return prize;
    }

    /**
     * 计算某人的累计奖金
     */
    private double sumPrize(String user, Date begin, Date end) {
        //计算累计奖金，其实应该按照人员去获取累计的业务额，然后再乘0.1%
        //简单演示一下，假定大家的累计业务额都是1000000元
        double prize = 1000000 * 0.001;
        System.out.println(user + "累计奖金" + prize);
        return prize;
    }

    /**
     * 判断人员是不同人员还是业务经理
     *
     * @param user
     * @return true 表示业务经理
     */
    private boolean isManager(String user) {
        //简单假设只有王五是经理
        if ("王五".equals(user)) {
            return true;
        }
        return false;
    }

    /**
     * 计算当月团队业务将
     */
    public double groupPrize(String user, Date begin, Date end) {
        //计算当月团队业务奖金，先计算处团队的业务额，然后再乘以1%
        double group = 0.0;
        for (double d :TempDB.mapMonthSaleMoney.values()){
            group += d;
        }
        double prize = group *0.01;
        System.out.println(user +"当月团队业务奖金"+prize);
        return prize;
    }

}
