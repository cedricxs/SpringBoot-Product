package com.cedricxs.application.utils;

import com.cedricxs.application.po.CommentPO;

import java.text.MessageFormat;

/**
 * @author chaxingshuo
 * @date 2021/07/12
 */
public class RedisKeyBuilder {

    public static final String COMMENT_PO_KEY = "comment";

    private static final String COMMENT_PO_KEY_FORMAT = "comment_{0}";

    public static String buildCommentPoKey(CommentPO commentPO) {
        return MessageFormat.format(COMMENT_PO_KEY_FORMAT, commentPO);
    }
}
