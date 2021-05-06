package life.wt.community.controller;

import life.wt.community.dto.CommentDTO;
import life.wt.community.mapper.CommentMapper;
import life.wt.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @created by wt at 2021-05-05 22:36
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setObserver(1);
        comment.setLikeCount(0);
        commentMapper.insert(comment);
        return "commen";
    }
}