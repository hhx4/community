package life.wt.community.dto;

import life.wt.community.model.User;
import lombok.Data;

/**
 * @author hw
 * @program community
 * @description
 * @create 2021-05-21 19:19
 **/
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}