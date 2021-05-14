package life.wt.community.dto;

import lombok.Data;

import java.util.*;

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
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalPage,Integer page) {
        this.page = page;
        this.totalPage = totalPage;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0,page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        showPrevious = page != 1 && page!=0;

        showNext = !page.equals(totalPage);

        showFirstPage = !pages.contains(1)&& page!=0;

        showEndPage = !pages.contains(totalPage);
    }

    public static void sortByHot(PaginationDTO paginationDTO) {
        if(paginationDTO.questions == null){
            return;
        }
        paginationDTO.questions.sort(Comparator.comparingInt(QuestionDTO::getViewCount));
    }
}