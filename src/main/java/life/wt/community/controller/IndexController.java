package life.wt.community.controller;

import life.wt.community.dto.PaginationDTO;
import life.wt.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @create 2021-04-23 19:44
 **/
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "5") Integer size) {

        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("section","");
        model.addAttribute("pagination", pagination);
        return "index";
    }

    @GetMapping("/sort_type-hot-7")
    public String listByhot(Model model,
                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PaginationDTO pagination = questionService.list(page, size);
        PaginationDTO.sortByHot(pagination);
        model.addAttribute("section","sort_type-hot-7");
        model.addAttribute("pagination", pagination);
        return "index";
    }
}