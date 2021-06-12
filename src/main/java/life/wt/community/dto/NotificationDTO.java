package life.wt.community.dto;

import lombok.Data;

/**
 * @created by wt at 2021-06-09 18:57
 **/
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}