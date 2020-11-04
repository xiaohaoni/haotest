package com.hao.mode.factory.absfactory.pizza;


/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:30
 **/
public class BJGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京希腊披萨");
        System.out.println("给制作希腊披萨，准备材料");
    }
}
