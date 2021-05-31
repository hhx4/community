package life.wt.community.dto;

import life.wt.community.model.User;
import lombok.Data;

/**
 * @created by wt at 2021-04-28 18:45
 **/
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
