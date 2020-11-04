package com.hao.mode.prototype.order;

import com.hao.mode.prototype.Person;

/**
 * 客户端
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-04 10:40
 **/
public class Client {
    public static void main(String[] args) {
        PersonalOrder oa1 = new PersonalOrder();
        Product product = new Product();
        product.setProductName("产品1");
        oa1.setProduct(product);
        oa1.setOrderProductNum(100);
        System.out.println("第一次获取对象:"+oa1);
        PersonalOrder oa2 = (PersonalOrder) oa1.cloneOrder();
        oa2.getProduct().setProductName("产品2");
        oa2.setOrderProductNum(80);
        System.out.println("第二次克隆获取对象:"+oa2);
        System.out.println("获取原对象:"+oa1);
    }
}
