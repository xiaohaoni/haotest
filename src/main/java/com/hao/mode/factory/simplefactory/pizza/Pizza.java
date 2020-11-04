package com.hao.mode.factory.simplefactory.pizza;

/**
 * 披萨
 *
 * @author zrh
 * @version 1.0
 * @date 2020-10-24 14:29
 **/
public abstract class Pizza {
    protected String name;
    public abstract void prepare();
    public void bake(){
        System.out.println(name+"baking");
    }
    public void cut(){
        System.out.println(name+"cut");

    }
    public void box(){
        System.out.println(name+"box");

    }

    public void setName(String name) {
        this.name = name;
    }
}
