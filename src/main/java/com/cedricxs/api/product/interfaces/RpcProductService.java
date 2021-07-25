package com.cedricxs.api.product.interfaces;

import com.cedricxs.api.product.dto.AddProductDTO;
import com.cedricxs.api.product.dto.AddProductResultDTO;
import com.cedricxs.api.product.dto.GetProductResultDTO;
import com.cedricxs.application.exception.RepositoryException;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public interface RpcProductService {
    /**
     * 获取所有商品
     * @return
     */
    GetProductResultDTO getProduct();

    /**
     * 添加商品
     * @param addProductDTO
     * @return
     * @throws RepositoryException
     */
    AddProductResultDTO addProduct(AddProductDTO addProductDTO) throws RepositoryException;
}
