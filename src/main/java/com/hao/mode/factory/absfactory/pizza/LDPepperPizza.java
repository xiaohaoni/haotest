package com.hao.mode.factory.absfactory.pizza;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:29
 **/
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println("给制作胡椒披萨，准备材料");
    }
}
