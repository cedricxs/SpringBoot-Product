package com.cedricxs.application.provider;

import com.cedricxs.api.product.dto.AddProductDTO;
import com.cedricxs.api.product.dto.AddProductResultDTO;
import com.cedricxs.api.product.dto.GetProductResultDTO;
import com.cedricxs.api.product.interfaces.RpcProductService;
import com.cedricxs.application.bo.AddProductBO;
import com.cedricxs.application.exception.RepositoryException;
import com.cedricxs.application.service.ProductService;
import com.cedricxs.application.utils.ProductWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Slf4j
@Component
public class RpcProductServiceImpl implements RpcProductService {

    @Resource
    private ProductService productService;

    @Override
    public GetProductResultDTO getProduct() {
        return productService.getProduct();
    }

    @Override
    public AddProductResultDTO addProduct(AddProductDTO addProductDTO) throws RepositoryException {
        AddProductBO addProductBO = ProductWrapper.wrapperAddProductBO(addProductDTO);
        return productService.addProduct(addProductBO);
    }
}
