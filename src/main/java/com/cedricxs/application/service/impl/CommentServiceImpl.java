package com.cedricxs.application.service.impl;

import com.cedricxs.application.bo.AddCommentBO;
import com.cedricxs.application.dto.AddCommentResultDTO;
import com.cedricxs.application.exception.RepositoryException;
import com.cedricxs.application.po.CommentPO;
import com.cedricxs.application.repository.CommentRepository;
import com.cedricxs.application.service.CommentService;
import com.cedricxs.application.utils.CommentWrapper;
import com.cedricxs.application.utils.PoFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentRepository commentRepository;

    @Override
    public AddCommentResultDTO addComment(AddCommentBO addCommentBO) throws RepositoryException {
        CommentPO commentPO = PoFactory.factory(addCommentBO.getName(), addCommentBO.getEmail(), addCommentBO.getCategory(), addCommentBO.getMessage());
        if (commentRepository.save(commentPO)) {
            log.info("[CommentService.addComment] add comment service success. addCommentBO={}", addCommentBO);
            return CommentWrapper.wrapperCommentResultDTO(addCommentBO.getName(), addCommentBO.getEmail(), addCommentBO.getCategory(), addCommentBO.getMessage());
        } else {
            throw new RepositoryException();
        }
    }
}
