package com.cedricxs.api.product.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Builder
@Data
public class AddProductResultDTO implements Serializable {

    String name;

    Double price;
}
