package com.cedricxs.application.utils;

import com.cedricxs.api.product.dto.AddProductDTO;
import com.cedricxs.api.product.dto.AddProductResultDTO;
import com.cedricxs.api.product.dto.ProductDTO;
import com.cedricxs.application.bo.AddProductBO;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public class ProductWrapper {

    public static ProductDTO wrapperProductDTO(String productName, Double productPrice) {
        return ProductDTO.builder()
                .name(productName)
                .price(productPrice)
                .build();
    }

    public static AddProductResultDTO wrapperAddProductResultDTO(String productName, Double productPrice) {
        return AddProductResultDTO.builder()
                .name(productName)
                .price(productPrice)
                .build();
    }

    public static AddProductBO wrapperAddProductBO(AddProductDTO addProductDTO) {
        return AddProductBO.builder()
                .name(addProductDTO.getName())
                .price(addProductDTO.getPrice())
                .build();

    }
}
