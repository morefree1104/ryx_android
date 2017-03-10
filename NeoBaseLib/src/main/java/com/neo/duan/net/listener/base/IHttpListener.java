package com.neo.duan.net.listener.base;

/**
 * @author : neo.duan
 * @date : 	 2016/2/29
 * @desc : http请求监听器基类
 */
public interface IHttpListener {
    /**
     * 发起http请求前
     */
    int RESPONSE_START = 0;

    /**
     * 服务器返回成功
     */
    int RESPONSE_SUCCESS = 1;

    /**
     * 服务器返回失败回调
     */
    int RESPONSE_FAIL = 2;

    /**
     * 请求已取消
     */
    int RESPONSE_CANCEL = 3;

    /**
     * 服务器连接超时，unknown host回调
     */
    int RESPONSE_DONE = 4;

    /**
     * 网络连接不正常
     */
    int RESPONSE_ERROR = 5;

    /**
     * 服务器返回
     *
     * @param code       状态标记
     * @param jsonObject 服务器返回数据..只有成功jsonObject返回Modle,其他都是String提示信息
     * @param tag        请求标记
     */
    void onResponse(int code, Object jsonObject, int tag);
}
