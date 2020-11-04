package com.hao.mode.factory.factorymethod.order;

import com.hao.mode.factory.factorymethod.pizza.BJCheesePizza;
import com.hao.mode.factory.factorymethod.pizza.BJPepperPizza;
import com.hao.mode.factory.factorymethod.pizza.Pizza;

/**
 * 北京披萨
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 15:25
 **/
public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }else {
            return null;
        }
        return pizza;
    }

}

