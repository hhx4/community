package life.wt.community.exception;

/**
 * @created by wt at 2021-05-05 14:52
 **/
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(Integer code, String message) {
        this.message = message;
        this.code = this.code;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
