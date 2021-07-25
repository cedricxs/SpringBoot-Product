package com.cedricxs.application.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
@Builder
public class AddProductBO {

    private String name;

    private Double price;
}
