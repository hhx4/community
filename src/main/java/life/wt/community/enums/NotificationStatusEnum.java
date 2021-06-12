package life.wt.community.enums;

/**
 * @created by wt at 2021-06-09 19:02
 **/
public enum NotificationStatusEnum {
    UNREAD(0), READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}