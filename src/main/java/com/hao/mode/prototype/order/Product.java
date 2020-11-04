package com.hao.mode.prototype.order;

import lombok.Data;

/**
 * 产品对象
 *
 * @author zrh
 * @version 1.0
 * @date 2020-11-04 10:29
 **/
@Data
public class Product implements ProductPrototype{
    private String productId;
    private String productName;

    @Override
    public ProductPrototype cloneProduct() {
        Product product = new Product();
        product.setProductId(this.productId);
        product.setProductName(this.productName);

        return product;
    }
}
