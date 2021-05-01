package life.wt.community.model;

import lombok.Data;

/**
 * @created by wt at 2021-04-26 21:41
 **/
@Data
public class Question {
    private int id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

}