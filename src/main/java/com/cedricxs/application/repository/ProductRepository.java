package com.cedricxs.application.repository;

import com.cedricxs.application.po.ProductPO;

import java.util.List;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public interface ProductRepository {

    /**
     * 获取所有商品
     * @return
     */
    List<ProductPO> getAll();

    /**
     * 保存商品
     * @param productPO
     * @return 保存成功与否
     */
    boolean save(ProductPO productPO);
}
