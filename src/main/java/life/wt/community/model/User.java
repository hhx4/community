package life.wt.community.model;

import lombok.Data;

/**
 * @created by wt at 2021-04-24 17:01
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatarUrl;
}