package life.wt.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @created by wt at 2021-06-04 09:12
 **/
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}