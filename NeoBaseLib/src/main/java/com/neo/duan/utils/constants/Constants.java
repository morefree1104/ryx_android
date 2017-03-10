package com.neo.duan.utils.constants;


import com.neo.duan.BuildConfig;

/**
 * @author : neo.duan
 * @date : 	 2016/7/26 0026
 * @desc : 常量
 */
public interface Constants {
    //项目名
    String PROJECT = "weiyi";
    //数据库名称
    String DB_NAME = "weiyi.db";
    //数据库版本
    int DB_VERSION = 1;
    //默认渠道号
    String DEFAULT_CHANNEL = "weiyi";
    //app key
    String WEIYI_KEY = "Wre368aR";

    //测试地址
    String SERVER_HOST_DEV = "http://weiyi.api.kuaijihudong.net/WeiyiAPI.ashx/";
    //正式地址
    String SERVER_HOST_RELEASE = "http://weiyi.api.kuaijihudong.net/WeiyiAPI.ashx/";

    String SERVER_HOST = BuildConfig.DEBUG ? SERVER_HOST_DEV : SERVER_HOST_RELEASE;

    int PAGE_SIZE = 15;
}
