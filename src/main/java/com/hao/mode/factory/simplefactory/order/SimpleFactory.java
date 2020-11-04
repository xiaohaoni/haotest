package com.hao.mode.factory.simplefactory.order;

import com.hao.mode.factory.simplefactory.pizza.CheesePizza;
import com.hao.mode.factory.simplefactory.pizza.GreekPizza;
import com.hao.mode.factory.simplefactory.pizza.PepperPizza;
import com.hao.mode.factory.simplefactory.pizza.Pizza;

/**
 * 披萨工厂
 *简单工厂 静态工厂
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:31
 **/
public class SimpleFactory {
    //更加 orderType 返回对应的 Pizza 对象
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }

    /**
     * 写成静态调用
     * */
    public static Pizza createPizza2(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }

}
