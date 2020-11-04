package com.hao.mode.bridge;

/**
 * 手机
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 23:01
 **/
public class Phone {
    //组合品牌
    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }
    protected void open(){
        brand.open();
    }
    protected void close(){
        brand.close();
    }
    protected  void call(){
        brand.close();
    }
}
