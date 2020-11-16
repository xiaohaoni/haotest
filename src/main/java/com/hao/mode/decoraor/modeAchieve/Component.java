package com.hao.mode.decoraor.modeAchieve;

import java.util.Date;

/**
 * 装饰者模式
 * 计算奖金的组件接口
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 16:02
 **/
public abstract class Component {

    /**
     * 计算某人在某段时间内的奖金，有些参数在铅山中并不会使用
     * @param user 被计算奖金的人员
     * @param begin 开始使时间
     * @param end 结束时间
     * @return 某人某段时间在某段时间内的奖金
     * */
    public abstract double calcPrize(String user, Date begin, Date end);
}
