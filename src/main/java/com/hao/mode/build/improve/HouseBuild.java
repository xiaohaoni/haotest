package com.hao.mode.build.improve;

/**
 * 抽象建造者
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:34
 **/
public abstract class HouseBuild {
    protected House house = new House();

    /**
     * 方法
     */
    public   abstract void buildBasis();

    public abstract void buildWalls();

    public abstract void roofed();

    public House buildHouse(){
        return  house;
    }

}
