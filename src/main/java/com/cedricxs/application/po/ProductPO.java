package com.cedricxs.application.po;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
@Builder
public class ProductPO {

    @Tolerate
    ProductPO(){

    }
    String name;

    Double price;
}
