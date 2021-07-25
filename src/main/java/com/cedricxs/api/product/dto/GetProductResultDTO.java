package com.cedricxs.api.product.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
@Builder
public class GetProductResultDTO implements Serializable {
    private List<ProductDTO> productDTOList;
}
