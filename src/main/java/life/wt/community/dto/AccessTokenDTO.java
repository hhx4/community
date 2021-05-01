package life.wt.community.dto;

import lombok.Data;

/**
 * @created by wt at 2021-04-24 09:42
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}