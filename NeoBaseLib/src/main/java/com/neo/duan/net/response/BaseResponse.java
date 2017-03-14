package com.neo.duan.net.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author : neo.duan
 * @date : 	 2016/9/20
 * @desc : 服务器返回实体基类
 */
public class BaseResponse<T> {
    private static final String SUCCESS = "OK";


    @JSONField(name = "Status")
    private String Status;

    @JSONField(name = "ResponseData")
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return SUCCESS.equals(Status);
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}


