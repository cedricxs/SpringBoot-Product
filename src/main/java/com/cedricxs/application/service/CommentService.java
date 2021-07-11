package com.cedricxs.application.service;

import com.cedricxs.application.bo.AddCommentBO;
import com.cedricxs.application.dto.AddCommentResultDTO;
import com.cedricxs.application.exception.RepositoryException;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
public interface CommentService {
    /**
     * 添加评论
     * @param addCommentBO
     * @return
     */
    AddCommentResultDTO addComment(AddCommentBO addCommentBO) throws RepositoryException;
}
