package life.wt.community.exception;

/**
 * @created by wt at 2021-05-05 14:52
 **/
public class CustomizeException extends RuntimeException{
    private String message;
    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
