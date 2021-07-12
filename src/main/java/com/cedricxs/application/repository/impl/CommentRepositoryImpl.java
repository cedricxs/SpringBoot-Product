package com.cedricxs.application.repository.impl;

import com.alibaba.fastjson.JSON;
import com.cedricxs.application.db.RedisManager;
import com.cedricxs.application.po.CommentPO;
import com.cedricxs.application.repository.CommentRepository;
import com.cedricxs.application.utils.RedisKeyBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.thymeleaf.expression.Lists;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
@Slf4j
@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @Resource
    private RedisManager redisManager;

    @Override
    public boolean save(CommentPO commentPO) {
        if (redisManager.hset(RedisKeyBuilder.COMMENT_PO_KEY, RedisKeyBuilder.buildCommentPoKey(commentPO), JSON.toJSONString(commentPO))) {
            log.info("[CommentRepository.save] save comment success. comment={}", JSON.toJSONString(commentPO));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CommentPO> getAll() {
        List<Object> list = redisManager.hvals(RedisKeyBuilder.COMMENT_PO_KEY);
        return Optional.ofNullable(list)
                .orElseGet(ArrayList::new)
                .stream()
                .map((v) -> JSON.parseObject((String)v, CommentPO.class))
                .collect(Collectors.toList());
    }


}
