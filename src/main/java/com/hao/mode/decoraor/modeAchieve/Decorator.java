package com.hao.mode.decoraor.modeAchieve;

import java.util.Date;

/**
 * 装饰者模式
 * 装饰的接口，需要和被装饰的对象实现同样的接口
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 16:06
 **/
public class Decorator extends Component{

    /**
     * 持有被装饰的组件对象
     * */
    protected Component c;

    /**
     * 通过构造方法传入被装饰的对象
     * */
    public Decorator(Component c) {
        this.c = c;
    }


    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //调用组件对象的方法
        return c.calcPrize(user,begin,end);
    }
}
