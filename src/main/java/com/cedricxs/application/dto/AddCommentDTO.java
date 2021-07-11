package com.cedricxs.application.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
@Data
@ToString
public class AddCommentDTO {

    private String name;

    private String email;

    private Integer category;

    private String message;

}
