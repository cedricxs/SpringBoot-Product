package com.cedricxs.application.controller;

import com.cedricxs.application.bo.AddCommentBO;
import com.cedricxs.application.dto.AddCommentDTO;
import com.cedricxs.application.dto.AddCommentResultDTO;
import com.cedricxs.application.exception.RepositoryException;
import com.cedricxs.application.service.CommentService;
import com.cedricxs.application.utils.CommentWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
@RestController
public class CommentController {

    @Resource
    CommentService commentService;

    @PostMapping(path = "/comment")
    public ResponseEntity<AddCommentResultDTO> addComment(@RequestBody AddCommentDTO addCommentDTO) throws RepositoryException {
        AddCommentBO addCommentBO = CommentWrapper.wrapperCommentBO(addCommentDTO);
        AddCommentResultDTO addCommentResultDTO = commentService.addComment(addCommentBO);
        ResponseEntity<AddCommentResultDTO> response = new ResponseEntity<>(addCommentResultDTO, HttpStatus.OK);
        return response;
    }
}