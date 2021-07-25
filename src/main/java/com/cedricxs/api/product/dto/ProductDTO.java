package com.cedricxs.api.product.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
@Builder
public class ProductDTO implements Serializable {

    private String name;

    private Double price;
}
