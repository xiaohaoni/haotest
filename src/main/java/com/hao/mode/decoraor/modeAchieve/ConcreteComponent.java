package com.hao.mode.decoraor.modeAchieve;

import java.util.Date;

/**
 * 装饰者模式
 * 基本的实现计算奖金的类，也是被装饰的对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 16:01
 **/
public class ConcreteComponent extends Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //默认实现，没有奖金
        return 0;
    }
}
