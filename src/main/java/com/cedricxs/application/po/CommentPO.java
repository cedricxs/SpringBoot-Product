package com.cedricxs.application.po;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
@Data
@Builder
@ToString
public class CommentPO {

    private String name;

    private String email;

    private Integer category;

    private String message;
}
