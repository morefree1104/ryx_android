package com.neo.duan.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * @author : neo.duan
 * @date : 	 2016/9/12 0029
 * @desc : 有关渠道号工具类
 */
public class ChannelUtils {

    private ChannelUtils() {
        throw new AssertionError();
    }

    /**
     * 获取渠道号
     *
     * @param ctx
     * @return
     */
    public static String getChannel(Context ctx) {
        String key = "UMENG_CHANNEL";
        if (ctx == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo =
                        packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return resultData;
    }
}
