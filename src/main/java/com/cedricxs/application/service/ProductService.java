package com.cedricxs.application.service;

import com.cedricxs.api.product.dto.AddProductResultDTO;
import com.cedricxs.api.product.dto.GetProductResultDTO;
import com.cedricxs.application.bo.AddProductBO;
import com.cedricxs.application.exception.RepositoryException;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public interface ProductService {

    /**
     * 获取所有商品
     * @return
     */
    GetProductResultDTO getProduct();

    /**
     * 添加商品
     * @param addProductBO
     * @return
     * @throws RepositoryException
     */
    AddProductResultDTO addProduct(AddProductBO addProductBO) throws RepositoryException;
}
