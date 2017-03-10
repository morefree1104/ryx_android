package com.neo.duan.event.base;

/**
 * @author : neo.duan
 * @date : 	 2016/8/15
 * @desc : EventBus中Event基类
 */
public class BaseEvent<T> implements EventCode {
    protected int code;   //消息code，用来区分成功失败等
    protected Object eventTag; //请求码:标识请求事件的类
    protected T data;
    private ExceptionEvent exception;

    public BaseEvent() {
    }

    public BaseEvent(int code) {
        this.code = code;
    }

    public BaseEvent(Object eventTag) {
        this.eventTag = eventTag;
    }

    public BaseEvent(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public BaseEvent(int code, ExceptionEvent exception) {
        this.code = code;
        this.exception = exception;
    }

    public BaseEvent(ExceptionEvent exception) {
        this.exception = exception;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if (code == EventCode.SUCCESS) {
            this.exception = null;
        }
        if (code == EventCode.START) {
            this.data = null;
            this.exception = null;
        }
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ExceptionEvent getException() {
        return exception;
    }

    public void setException(ExceptionEvent exception) {
        this.exception = exception;
    }

    public Object getTag() {
        return eventTag;
    }

    public BaseEvent setTag(Object tag) {
        this.eventTag = tag;
        return this;
    }
}
