package com.hao.mode.build.improve;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 普通房子
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 21:38
 **/
public class CommonHouse extends HouseBuild{
    @Override
    public void buildBasis() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子高10m");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostName());
    }
}
