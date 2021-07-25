package com.cedricxs.application.repository.impl;

import com.alibaba.fastjson.JSON;
import com.cedricxs.application.db.MockDataBase;
import com.cedricxs.application.po.ProductPO;
import com.cedricxs.application.repository.ProductRepository;
import com.cedricxs.application.utils.RedisKeyBuilder;
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
@Repository("mockProductRepository")
@Profile("local")
public class MockProductRepositoryImpl implements ProductRepository {

    private static final String TABLE_NAME = "product";

    @Resource
    private MockDataBase mockDataBase;

    @Override
    public boolean save(ProductPO productPO) {
        return mockDataBase.set(TABLE_NAME, RedisKeyBuilder.buildProductPoKey(productPO), JSON.toJSONString(productPO));
    }

    @Override
    public List<ProductPO> getAll() {
        return Optional.ofNullable(mockDataBase.getAll(TABLE_NAME))
                .orElseGet(ArrayList::new)
                .stream()
                .map(strings -> JSON.parseObject(strings, ProductPO.class))
                .collect(Collectors.toList());
    }
}
