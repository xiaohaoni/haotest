package com.hao.mode.build.improve;

/**
 * 高楼
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:41
 **/
public class HighHouse extends HouseBuild{
    @Override
    public void buildBasis() {
        System.out.println("高楼房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼房子高10m");
    }

    @Override
    public void roofed() {
        System.out.println("高楼房子封顶");
    }
}
