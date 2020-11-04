package com.hao.mode.factory.factorymethod.pizza;

import com.hao.mode.factory.simplefactory.pizza.Pizza;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:30
 **/
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        System.out.println("给制作奶酪披萨，准备材料");
    }
}
