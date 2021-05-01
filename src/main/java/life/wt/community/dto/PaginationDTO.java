package life.wt.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @created by wt at 2021-05-01 10:59
 **/
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount,Integer page, Integer size) {
        int totalPage = 0;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0,page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        showPrevious = page != 1;

        showNext = !page.equals(totalPage);

        showFirstPage = !pages.contains(1);

        showEndPage = !pages.contains(totalPage);
    }
}