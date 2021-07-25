package com.cedricxs.application.repository.impl;

import com.alibaba.fastjson.JSON;
import com.cedricxs.application.db.RedisManager;
import com.cedricxs.application.po.ProductPO;
import com.cedricxs.application.repository.ProductRepository;
import com.cedricxs.application.utils.RedisKeyBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

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
@Repository
@Profile({"dev"})
public class ProductRepositoryImpl implements ProductRepository {

    @Resource
    private RedisManager redisManager;

    @Override
    public List<ProductPO> getAll() {
        List<Object> list = redisManager.hvals(RedisKeyBuilder.PRODUCT_PO_KEY);
        return Optional.ofNullable(list)
                .orElseGet(ArrayList::new)
                .stream()
                .map((v) -> JSON.parseObject((String)v, ProductPO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean save(ProductPO productPO) {
        if (redisManager.hset(RedisKeyBuilder.PRODUCT_PO_KEY, RedisKeyBuilder.buildProductPoKey(productPO), JSON.toJSONString(productPO))) {
            log.info("[ProductRepository.save] save product success. product={}", JSON.toJSONString(productPO));
            return true;
        } else {
            return false;
        }
    }
}
