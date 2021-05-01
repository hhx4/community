package life.wt.community.dto;

import lombok.Data;

/**
 * @created by wt at 2021-04-24 10:20
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

}