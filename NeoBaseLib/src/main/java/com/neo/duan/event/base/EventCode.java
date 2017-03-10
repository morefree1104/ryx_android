package com.neo.duan.event.base;

/**
 * @author : neo.duan
 * @date : 	 2016/8/19
 * @desc : 事件状态码
 */
public interface EventCode {
    /**
     * 开始事件
     */
    int START = 1;

    /**
     * 事件成功
     */
    int SUCCESS = 2;

    /**
     * 事件失败
     */
    int FAIL = 3;

    /**
     * 事件取消
     */
    int CANCEL = 4;
}
