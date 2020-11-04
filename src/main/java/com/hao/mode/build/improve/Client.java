package com.hao.mode.build.improve;

/**
 * 客户端
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:48
 **/
public class Client {
    public static void main(String[] args) {
        //盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();
    }
}
