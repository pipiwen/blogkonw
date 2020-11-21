package com.ppw.blogknow.handler;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/11/18 18:40 <br>
 * @see com.ppw.blogknow.handler <br>
 */
public class BaseBusinessException extends RuntimeException {


    private Integer code;

    private String message;

    public BaseBusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
