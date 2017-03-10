package com.neo.duan.entity;

import android.content.Context;

import com.neo.duan.utils.AppUtils;
import com.neo.duan.utils.ChannelUtils;
import com.neo.duan.utils.constants.Constants;


/**
 * @author : neo.duan
 * @date : 	 2016/8/17 0017
 * @desc : 有关app信息
 */
public class AppInfo {
    public String appName; //app名称
    public String versionName; //版本号
    public int versionCode; //代码版本号
    public String channel = Constants.DEFAULT_CHANNEL; //渠道号
    public boolean isInBackground; //是否在后台运行

    public static AppInfo init(Context context) {
        AppInfo info = new AppInfo();
        info.appName = AppUtils.getAppName(context);
        info.versionName = AppUtils.getVersionName(context);
        info.versionCode = AppUtils.getVersionCode(context);
        info.channel = ChannelUtils.getChannel(context);
        info.isInBackground = AppUtils.isApplicationInBackground(context);
        return info;
    }

}
