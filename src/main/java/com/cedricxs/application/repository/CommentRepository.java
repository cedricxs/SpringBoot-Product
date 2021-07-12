package com.cedricxs.application.repository;

import com.cedricxs.application.po.CommentPO;

import java.util.List;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
public interface CommentRepository {
    /**
     * 保存comment
     * @param commentPO
     * @return 保存成功与否
     */
    boolean save(CommentPO commentPO);

    /**
     * 获取所有comment
     * @return comment列表
     */
    List<CommentPO> getAll();
}
