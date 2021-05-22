package life.wt.community.dto;

import lombok.Data;

/**
 * @created by wt at 2021-05-05 23:48
 **/
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}