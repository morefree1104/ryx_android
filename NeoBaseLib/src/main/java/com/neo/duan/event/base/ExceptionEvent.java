package com.neo.duan.event.base;

/**
 * @author : neo.duan
 * @date : 	 2016/8/19
 * @desc : 异常事件
 */
public class ExceptionEvent {
    private int statusCode;
    private String errorMsg;

    public ExceptionEvent(int statusCode) {
        this.statusCode = statusCode;
    }

    public ExceptionEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ExceptionEvent(int statusCode, String errorMsg) {
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
