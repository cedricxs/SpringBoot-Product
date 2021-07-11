package com.cedricxs.application.bo;

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
public class AddCommentBO {

    private String name;

    private String email;

    private Integer category;

    private String message;
}
