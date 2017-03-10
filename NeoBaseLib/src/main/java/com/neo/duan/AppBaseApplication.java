package com.neo.duan;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.neo.duan.entity.AppInfo;
import com.neo.duan.entity.DeviceInfo;
import com.neo.duan.manager.ImageManager;
import com.neo.duan.manager.ScreenManager;
import com.neo.duan.utils.LogUtils;
import com.neo.duan.utils.PermissionsChecker;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.neo.duan.ui.widget.swipemenu.SwipeMenuLayout.TAG;

/**
 * @author : neo.duan
 * @date : 	 2016/7/25 0025
 * @desc : app
 */
public class AppBaseApplication extends MultiDexApplication {
    public static AppBaseApplication instance;

    public static AppBaseApplication getInstance() {
        return instance;
    }

    public static AppInfo mAppInfo; //app信息
    public static DeviceInfo mDeviceInfo; //device信息

    public static String mToken;
    private String[] mPermissions; //权限集合
    public final static List<Class> mTableClzList = new ArrayList<>(); //数据库表集合

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //初始化打印日志
        Logger.init();

        //初始化应用图片加载库
        ImageManager.getInstance().init(this);

        //初始化异常管理器
//        Thread.setDefaultUncaughtExceptionHandler(ExceptionManager.getInstance());

        //初始化设备信息：判断是否有权限
        if (mPermissions != null && mPermissions.length > 0) {
            PermissionsChecker mPermissionsChecker = new PermissionsChecker(this);
            boolean hasAllPermissions = !mPermissionsChecker.lacksPermissions(mPermissions);
            // 缺少权限时,不初始化设备，一般在Splash页面做
            if (hasAllPermissions) {
                LogUtils.d(TAG, "hasAllPermissions initDeviceAndApp");
                initDeviceAndApp();
            }
        }
    }

    /**
     * 初始化设备信息和app信息，6.0需要权限，在BaseActivity中处理
     */
    public void initDeviceAndApp() {
        if (mAppInfo == null) {
            mAppInfo = AppInfo.init(this);
        }
        if (mDeviceInfo == null) {
            mDeviceInfo = DeviceInfo.init(this);
        }
    }

    /**
     * 添加数据库表Class
     *
     * @param clz
     */
    public void addDbTableClass(Class clz) {
        mTableClzList.add(clz);
    }


    public void setPermissions(String[] permissions) {
        this.mPermissions = permissions;
    }

    public String[] getPermissions() {
        return mPermissions;
    }

    /**
     * 获取顶部Activity
     *
     * @return
     */
    public Activity getTopActivity() {
        return ScreenManager.getInstance().currentActivity();
    }
}
