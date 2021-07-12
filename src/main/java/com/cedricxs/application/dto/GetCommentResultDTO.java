package com.cedricxs.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author chaxingshuo
 * @date 2021/07/12
 */
@Data
@Builder
@ToString
public class GetCommentResultDTO {

    private List<CommentDTO> commentDTOList;
}
