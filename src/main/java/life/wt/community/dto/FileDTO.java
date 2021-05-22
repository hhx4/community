package life.wt.community.dto;

import lombok.Data;

/**
 * @author hw
 * @program community
 * @description
 * @create 2021-05-21 22:31
 **/

@Data
public class FileDTO {
    private int success;
    private String message;
    private String url;
}