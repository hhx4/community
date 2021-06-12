package life.wt.community.controller;

import life.wt.community.dto.PaginationDTO;
import life.wt.community.model.User;
import life.wt.community.service.NotificationService;
import life.wt.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @created by wt at 2021-05-01 16:45
 **/
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action, Model model,
                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size) {

        User user = (User)request.getSession().getAttribute("user");

        if(user == null){
            return "redirect:/";
        }

            if ("questions".equals(action)) {
                model.addAttribute("section", "questions");
                model.addAttribute("sectionName", "我的提问");
                PaginationDTO paginationDTO = questionService.list(user.getId(),page,size);
                model.addAttribute("pagination", paginationDTO);
            } else if ("replies".equals(action)) {
                PaginationDTO paginationDTO = notificationService.list(user.getId(), page, size);
                model.addAttribute("section", "replies");
                model.addAttribute("pagination", paginationDTO);
                model.addAttribute("sectionName", "最新回复");
            }
            return "profile";
        }
        @GetMapping("profile")
        public String profile(){
            return "profile";
        }

}