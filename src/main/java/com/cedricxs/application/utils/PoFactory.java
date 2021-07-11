package com.cedricxs.application.utils;

import com.cedricxs.application.po.CommentPO;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
public class PoFactory {

    public static CommentPO factory(String name, String email, Integer category, String message) {
        CommentPO commentPO = CommentPO.builder()
                .name(name)
                .email(email)
                .category(category)
                .message(message)
                .build();
        return commentPO;
    }
}
