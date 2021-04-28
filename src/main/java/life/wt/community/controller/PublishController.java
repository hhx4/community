package life.wt.community.controller;

import life.wt.community.mapper.QuestionMaper;
import life.wt.community.mapper.UserMapper;
import life.wt.community.model.Question;
import life.wt.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @created by wt at 2021-04-26 15:41
 **/
@Controller
public class PublishController {
    @Autowired
    private QuestionMaper questionMaper;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            HttpServletRequest request, Model model){

        if(title == null||"".equals(title)){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        model.addAttribute("title",title);
        if(description == null||"".equals(description)){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        model.addAttribute("description",description);
        if(tag == null||"".equals(tag)){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        model.addAttribute("tag",tag);
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
            if(user == null){
                model.addAttribute("error","用户未登录");
                return "publish";
            }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMaper.create(question);
        return "redirect:/";
    }
}