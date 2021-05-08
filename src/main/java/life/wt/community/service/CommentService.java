package life.wt.community.service;

/**
 * @created by wt at 2021-05-07 00:18
 **/

import life.wt.community.exception.CustomizeErrorCode;
import life.wt.community.exception.CustomizeException;
import life.wt.community.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getObserver() == null) {
            throw new CustomizeException( CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
    }
}