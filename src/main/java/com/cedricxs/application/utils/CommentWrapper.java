package com.cedricxs.application.utils;

import com.cedricxs.application.bo.AddCommentBO;
import com.cedricxs.application.dto.AddCommentDTO;
import com.cedricxs.application.dto.AddCommentResultDTO;
import com.cedricxs.application.po.CommentPO;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
public class CommentWrapper {

    public static AddCommentBO wrapperCommentBO(AddCommentDTO addCommentDTO) {
        AddCommentBO addCommentBO = AddCommentBO.builder()
                .name(addCommentDTO.getName())
                .email(addCommentDTO.getEmail())
                .category(addCommentDTO.getCategory())
                .message(addCommentDTO.getMessage())
                .build();
        return addCommentBO;
    }

    public static AddCommentResultDTO wrapperCommentResultDTO(String name, String email, Integer category, String message) {
        AddCommentResultDTO addCommentResultDTO = AddCommentResultDTO.builder()
                .name(name)
                .email(email)
                .category(category)
                .message(message)
                .build();
        return addCommentResultDTO;
    }
}
