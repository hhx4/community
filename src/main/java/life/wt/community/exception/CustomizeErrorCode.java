package life.wt.community.exception;

/**
 * @created by wt at 2021-05-05 15:23
 **/
public enum  CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND("抱歉，当前问题不存在！");

    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    CustomizeErrorCode(String message){
        this.message = message;
    }
}