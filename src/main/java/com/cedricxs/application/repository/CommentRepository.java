package com.cedricxs.application.repository;

import com.cedricxs.application.po.CommentPO;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
public interface CommentRepository {
    /**
     * @param commentPO
     * @return
     */
    boolean save(CommentPO commentPO);
}
