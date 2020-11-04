package com.hao.mode.prototype.order;

import lombok.Data;
import org.springframework.security.core.parameters.P;

/**
 * @author zrh
 * @version 1.0
 * @date 2020-11-04 10:34
 **/
@Data
public class PersonalOrder implements OrderApi{
    private String customerName;
    private int orderProductNum = 0;
    private Product product = null;

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }
    public OrderApi cloneOrder(){
        PersonalOrder order = new PersonalOrder();
        order.setOrderProductNum(this.orderProductNum);
        order.setCustomerName(this.customerName);
        //实现了深拷贝
        order.setProduct((Product) this.product.cloneProduct());
        return order;

    }

    @Override
    public String toString() {
        return "PersonalOrder{" +
                "customerName='" + customerName + '\'' +
                ", orderProductNum=" + orderProductNum +
                ", product=" + product +
                '}';
    }
}
