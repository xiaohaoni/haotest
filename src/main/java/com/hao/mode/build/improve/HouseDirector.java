package com.hao.mode.build.improve;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:42
 * 指挥者
 **/
public class HouseDirector {
    HouseBuild houseBuild = null;
    //构造器传入houseBuild
    public HouseDirector(HouseBuild houseBuild){
        this.houseBuild = houseBuild;
    }
    //用set方法
    public void setHouseBuild(HouseBuild houseBuild){
        this.houseBuild = houseBuild;
    }

    /**
     * 如何处理建造房子的流程
     * */
    public  House constructHouse(){
        houseBuild.buildBasis();
        houseBuild.roofed();
        houseBuild.buildWalls();
        return houseBuild.buildHouse();
    }

}
