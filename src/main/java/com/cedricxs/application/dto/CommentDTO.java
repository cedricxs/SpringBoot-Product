package com.cedricxs.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author chaxingshuo
 * @date 2021/07/12
 */
@Data
@Builder
@ToString
public class CommentDTO {

    private String name;

    private String email;

    private Integer category;

    private String message;
}
