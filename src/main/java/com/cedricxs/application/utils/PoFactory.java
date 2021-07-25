package com.cedricxs.application.utils;

import com.cedricxs.application.po.ProductPO;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public class PoFactory {

    public static ProductPO factory(String productName, Double productPrice) {
        ProductPO productPO = ProductPO.builder()
                .name(productName)
                .price(productPrice)
                .build();
        return productPO;
    }
}
