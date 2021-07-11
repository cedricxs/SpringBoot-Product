package com.cedricxs.application.repository;

import com.cedricxs.application.po.CommentPO;
import org.springframework.stereotype.Repository;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
@Repository
public interface CommentRepository {
    /**
     * @param commentPO
     * @return
     */
    boolean save(CommentPO commentPO);
}
