package life.wt.community.exception;

/**
 * @created by wt at 2021-05-05 15:23
 **/
public enum  CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"抱歉，当前问题不存在！"),
    TARGET_PARAM_NOT_FOUND(2002,"未选择任何问题或评论回复") ,
    NO_LOGIN(2003,"当前操作需要登录，请登陆后重试"),
    SYS_ERROR(2004,"系统错误"),
    TYPE_PARAM_ERROR(2005,"错误的评论类型"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在"),
    COMMENT_IS_EMPTY(2007,"输入内容不能为空");


    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}