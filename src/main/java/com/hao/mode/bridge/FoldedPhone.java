package com.hao.mode.bridge;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-02 23:03
 **/
public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }
    @Override
    public void open(){
        super.open();
        System.out.println("折叠样式手机");
    }
    @Override
    public void close(){
        System.out.println("折叠样式手机");
        super.close();
    }
    @Override
    public void call(){

        super.close();
        System.out.println("折叠样式手机");
    }
}
