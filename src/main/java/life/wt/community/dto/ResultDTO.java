package life.wt.community.dto;

import life.wt.community.exception.CustomizeErrorCode;
import lombok.Data;

/**
 * @created by wt at 2021-05-07 00:07
 **/
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }
}

