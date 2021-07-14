package com.cedricxs.application.po;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
@Data
@Builder
@ToString
public class CommentPO {

    @Tolerate
    public CommentPO() {
    }

    private String name;

    private String email;

    private Integer category;

    private String message;
}
