package com.ryx.ryx;

import android.Manifest;
import android.app.Activity;

import com.neo.duan.AppBaseApplication;
import com.neo.duan.manager.ScreenManager;
import com.neo.duan.utils.LogUtils;
import com.ryx.ryx.entity.UserInfo;
import com.ryx.ryx.manager.AccountManager;
import com.ryx.ryx.manager.CrashManager;
import com.tencent.bugly.crashreport.CrashReport;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.Date;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;

/**
 * @author : neo.duan
 * @date : 	 2016/7/25 0025
 * @desc : app
 */
public class RyxApplication extends AppBaseApplication {
    private static final String TAG = RyxApplication.class.getSimpleName();
    // 应用所需的全部权限
    public static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CALL_PHONE,
    };
//    public BDLocationListener myListener = new MyLocationListener();


    public static RyxApplication getInstance() {
        return (RyxApplication) instance;
    }

    public static AccountManager mAccountManager;//账户信息

    @Override
    public void onCreate() {
        //向BaseLib注入权限集合，校验是要初始化设备信息等
        setPermissions(PERMISSIONS);
        //注入需要创建的数据库表
        addDbTableClass(UserInfo.class);
        /*************以上需要在super.onCreate()前***********************/

        super.onCreate();
        LogUtils.d(TAG, "onCreate");
        //初始化账户信息管理类
        mAccountManager = AccountManager.init(this);
        //处理token
        if (isLogin()) {
            //TODO 等待接口更新
        }
        ZXingLibrary.initDisplayOpinion(this);
//        EMClient.getInstance().init(this, null);
        //注册EventBus


        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        //初始化异常管理器
        CrashManager.getInstance().init();
        //BUGLY  在线监控crash  发布为false，调试改为true
        CrashReport.initCrashReport(getApplicationContext(), "900058791", false);
    }

    public  void addLocalNotification(String title, String content, int notificationid, Date date){
        JPushLocalNotification ln = new JPushLocalNotification();
        ln.setBuilderId(0);
        ln.setContent(content);
        ln.setTitle(title);
        ln.setNotificationId(notificationid) ;
        ln.setBroadcastTime(date);
        JPushInterface.addLocalNotification(this, ln);
    }

    public  void removeLocalNotification(int notificationid){
        JPushLocalNotification ln = new JPushLocalNotification();
        JPushInterface.removeLocalNotification(this, notificationid);
    }

    /**
     * 是否为登录状态
     * @return
     */
    public boolean isLogin() {
        return getUserInfo() != null;
    }


    /**
     * 获取账户id，经常使用的单独拿出来
     * @returnc
     */
    public String getUserId() {
        return mAccountManager.getUserId();
    }


    public UserInfo getUserInfo() {
        return mAccountManager.getUserInfo();
    }


    public String getUserAccount() {
        return mAccountManager.getUserAccount();
    }
    public String getUserToken() {
        return mAccountManager.getUserToken();
    }

    public void setUserInfo(UserInfo userInfo) {
        //保存token
        if (userInfo == null) {
            mToken = "";
            return;
        }
        //TODO 等待接口更新TOKEN
//        mToken = userInfo.getToken();
        mAccountManager.setUserInfo(userInfo);
    }




    /**
     * 获取顶部Activity
     * @return
     */
    public Activity getTopActivity() {
        return ScreenManager.getInstance().currentActivity();
    }

//    @Subscribe
//    public void subscribeData(){
//
//    }

    /**
     * 退出登录：恢复到未登录状态
     */
    public void logout() {
        mAccountManager.clear();
    }

}
