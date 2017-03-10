package com.ryx.ryx.manager;

import android.content.Context;

import com.neo.duan.utils.LogUtils;
import com.neo.duan.utils.preferences.PreferencesUtils;
import com.ryx.ryx.db.UserDao;
import com.ryx.ryx.db.impl.UserDaoImpl;
import com.ryx.ryx.entity.UserInfo;
import com.ryx.ryx.utils.constants.PreferencesKey;

/**
 * @author : neo.duan
 * @date : 	 2016/9/12
 * @desc : 账户管理器：主要管理账户数据，与Application常驻存在，请从Application中获取
 */
public class AccountManager {
    private static final String TAG = AccountManager.class.getSimpleName();

    private Context context;

    public UserInfo userInfo;

    public AccountManager(Context context) {
        this.context = context;
    }

    public static final AccountManager init(Context context) {
        AccountManager manager = new AccountManager(context);
        if (manager.getUserInfo() == null) {
            String accountId = PreferencesUtils.getString(context, PreferencesKey.USER_ID, "");
            LogUtils.d(TAG, "accountId===" + accountId);
            UserInfo userInfo = manager.getAccountFromDB(accountId);
            if (userInfo != null) {
                manager.setUserInfo(userInfo);
                LogUtils.d(TAG, "userInfo===" + userInfo.toString());
            }
            LogUtils.e(TAG, "userInfo===null");
        }
        return manager;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }




    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        update(userInfo);
        if(userInfo != null){
            saveAccount(userInfo);
        }

    }

    /**
     * 获取账户id
     *
     * @return
     */
    public String getUserId() {
//        if (userInfo == null) {
//            return "";
//        }
//        return userInfo.getUserId();
        return PreferencesUtils.getString(context, PreferencesKey.USER_ID, null);
    }


    public String getUserToken() {
        return PreferencesUtils.getString(context, PreferencesKey.USER_TOKEN, null);
    }


    public String getUserAccount() {
        return PreferencesUtils.getString(context, PreferencesKey.ACCOUNT, "");
    }
    /**
     * 保存账户信息
     *
     * @param userInfo
     */
    public void saveAccount(UserInfo userInfo) {
        //需要最新执行首先remove之前的
        clear();

        //保存userId到本地配置
        PreferencesUtils.putString(context, PreferencesKey.USER_ID, userInfo.getUserId());

        //打印用户信息
        LogUtils.d(TAG,"userInfo ===" + userInfo.toString());

        //保存到数据库
        UserDao dao = new UserDaoImpl(context);
        dao.insert(userInfo);

        this.userInfo = userInfo;
    }

    /**
     * 更新用户信息：主要用户修改资料等
     * @param userInfo
     */
    public void update(UserInfo userInfo) {
        UserDao dao = new UserDaoImpl(context);
        dao.update(userInfo);

        this.userInfo = userInfo;
    }


    /**
     * 从数据库中获取账户信息
     * @param accountId
     * @return
     */
    public UserInfo getAccountFromDB(String accountId) {
        UserDao dao = new UserDaoImpl(context);
        return dao.get(accountId);
    }

    /***
     * 清除账户信息:包括本地数据库
     */
    public void clear() {
        new UserDaoImpl(context).clear();
        setUserInfo(null);
    }
}
