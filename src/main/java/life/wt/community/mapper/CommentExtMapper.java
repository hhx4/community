package life.wt.community.mapper;

import life.wt.community.model.Comment;

/**
 * @created by wt at 2021-06-01 23:58
 **/
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}