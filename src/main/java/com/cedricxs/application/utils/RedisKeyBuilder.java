package com.cedricxs.application.utils;

import com.cedricxs.application.po.ProductPO;

import java.text.MessageFormat;

/**
 * @author chaxingshuo
 * @date 2021/07/12
 */
public class RedisKeyBuilder {

    public static final String PRODUCT_PO_KEY = "product";

    private static final String PRODUCT_PO_KEY_FORMAT = "product_{0}";

    public static String buildProductPoKey(ProductPO productPO) {
        return MessageFormat.format(PRODUCT_PO_KEY_FORMAT, productPO);
    }
}
