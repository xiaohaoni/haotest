package com.hao.demo;

/**
 * 实现类
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-13 10:12
 **/
public class DogMain {

    public static void main(String[] args) {
        DogMain dogMain = new DogMain();
        Integer i = 1;
        dogMain.getDogObj(i);
        System.out.println(i);
    }

    private void getDogObj(Integer i){
        i+=4;
    }
}
