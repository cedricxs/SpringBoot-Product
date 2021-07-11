package com.cedricxs.application.repository.impl;

import com.cedricxs.application.po.CommentPO;
import com.cedricxs.application.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
@Slf4j
@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @Override
    public boolean save(CommentPO commentPO) {
        log.info("[CommentRepository.save] save comment success. comment={}", commentPO);
        return true;
    }
}
