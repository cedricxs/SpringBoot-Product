package com.cedricxs.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.cedricxs.api.product.dto.AddProductDTO;
import com.cedricxs.api.product.dto.AddProductResultDTO;
import com.cedricxs.api.product.dto.GetProductResultDTO;
import com.cedricxs.api.product.dto.ProductDTO;
import com.cedricxs.application.bo.AddProductBO;
import com.cedricxs.application.exception.RepositoryException;
import com.cedricxs.application.po.ProductPO;
import com.cedricxs.application.repository.ProductRepository;
import com.cedricxs.application.service.ProductService;
import com.cedricxs.application.utils.PoFactory;
import com.cedricxs.application.utils.ProductWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Override
    public GetProductResultDTO getProduct() {
        List<ProductPO> productPoList = productRepository.getAll();
        List<ProductDTO> productDTOList = Optional.ofNullable(productPoList)
                .orElseGet(ArrayList::new)
                .stream()
                .map((v) -> ProductWrapper.wrapperProductDTO(v.getName(), v.getPrice()))
                .collect(Collectors.toList());
        return GetProductResultDTO.builder()
                .productDTOList(productDTOList)
                .build();
    }

    @Override
    public AddProductResultDTO addProduct(AddProductBO addProductBO) throws RepositoryException {
        ProductPO productPO = PoFactory.factory(addProductBO.getName(), addProductBO.getPrice());
        if (productRepository.save(productPO)) {
            log.info("[ProductService.addProduct] add product service success. addProductBO={}", JSON.toJSONString(addProductBO));
            return ProductWrapper.wrapperAddProductResultDTO(addProductBO.getName(), addProductBO.getPrice());
        } else {
            throw new RepositoryException();
        }
    }

}
