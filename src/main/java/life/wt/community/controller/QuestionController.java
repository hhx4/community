package life.wt.community.controller;

import life.wt.community.dto.CommentCreateDTO;
import life.wt.community.dto.CommentDTO;
import life.wt.community.dto.QuestionDTO;
import life.wt.community.service.CommentService;
import life.wt.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * @created by wt at 2021-05-03 12:56
 **/
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.getById(id);

        List<CommentDTO> comments = commentService.listByQuestionId(id);
        questionService.inView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}