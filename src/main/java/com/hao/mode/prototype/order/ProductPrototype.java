package com.hao.mode.prototype.order;

/**
 * 原型模式
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-04 10:27
 **/
public interface ProductPrototype {
    /**
     * 克隆唱片自身的方法
     * @return  一个从自身科人出来的产品对象
     * */
    public ProductPrototype cloneProduct();
}
