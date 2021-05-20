package life.wt.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @created by wt at 2021-05-20 14:02
 **/
@Controller
public class AbortInfoController {
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}