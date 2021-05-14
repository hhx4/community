package life.wt.community.service;

/**
 * @created by wt at 2021-05-07 00:18
 **/

import life.wt.community.enums.CommentTypeEnum;
import life.wt.community.exception.CustomizeErrorCode;
import life.wt.community.exception.CustomizeException;
import life.wt.community.mapper.CommentMapper;
import life.wt.community.mapper.QuestionMapper;
import life.wt.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getObserver() == null) {
            throw new CustomizeException( CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND );
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {

        }else {

        }
    }
}