package com.hao.mode.factory.absfactory.order;

import com.hao.mode.factory.absfactory.pizza.Pizza;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 16:52
 **/
public interface AbsFactory {
    /**
     * 创建一个披萨
     * */
public Pizza createPizza(String orderType);
}
