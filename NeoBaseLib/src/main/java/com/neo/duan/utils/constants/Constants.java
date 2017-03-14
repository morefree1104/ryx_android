package com.neo.duan.utils.constants;


import com.neo.duan.BuildConfig;

/**
 * @author : neo.duan
 * @date : 	 2016/7/26 0026
 * @desc : 常量
 */
public interface Constants {
    //项目名
    String PROJECT = "ryx";
    //数据库名称
    String DB_NAME = "ryx.db";
    //数据库版本
    int DB_VERSION = 1;
    //默认渠道号
    String DEFAULT_CHANNEL = "ryx";

    //测试地址
    String SERVER_HOST_DEV = "http://112.74.28.147:8080/ryx/";
    //正式地址
    String SERVER_HOST_RELEASE = "http://weiyi.api.kuaijihudong.net/WeiyiAPI.ashx/";

    String SERVER_HOST = BuildConfig.DEBUG ? SERVER_HOST_DEV : SERVER_HOST_RELEASE;

    int PAGE_SIZE = 15;
}
