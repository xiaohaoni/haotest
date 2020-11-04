package com.hao.mode.factory.absfactory.order;

import com.hao.mode.factory.absfactory.pizza.BJCheesePizza;
import com.hao.mode.factory.absfactory.pizza.Pizza;

/**
 * 北京披萨工厂子类
 *
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 16:55
 **/
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJCheesePizza();
        }
        return pizza;
    }
}
