package com.ryx.ryx.mvp.present;

import com.neo.duan.mvp.present.BasePresenterImpl;
import com.neo.duan.utils.PermissionsChecker;
import com.neo.duan.utils.StringUtils;
import com.neo.duan.utils.preferences.PreferencesUtils;
import com.ryx.ryx.RyxApplication;
import com.ryx.ryx.entity.UserInfo;
import com.ryx.ryx.mvp.contract.SplashContract;
import com.ryx.ryx.utils.constants.PreferencesKey;

import static com.ryx.ryx.RyxApplication.PERMISSIONS;
import static com.neo.duan.AppBaseApplication.mAppInfo;

/**
 * @author : neo.duan
 * @date : 	 2016/10/8
 * @desc : 闪屏页面Presenter的实现类
 */
public class SplashPresenterImpl extends BasePresenterImpl<SplashContract.View, SplashContract.Interactor>
        implements SplashContract.Presenter {

    private PermissionsChecker mPermissionsChecker; // 权限检测器
    private boolean mHasAllPermissions;

    public SplashPresenterImpl(SplashContract.View view) {
        super(view);
    }

    @Override
    public SplashContract.Interactor initInteractor() {
        return null;
    }

    @Override
    public void setHasAllPermissions(boolean hasAllPermissions) {
        mHasAllPermissions = hasAllPermissions;
    }

    @Override
    public void checkPermissions() {
        //判断是否有权限
        if (mPermissionsChecker == null) {
            mPermissionsChecker = new PermissionsChecker(view.getContext());
        }
        mHasAllPermissions = !mPermissionsChecker.lacksPermissions(PERMISSIONS);

        // 缺少权限时, 进入权限配置页面
        if (!mHasAllPermissions) {
            view.goPermissionsActivity();
            return;
        }

        //有所有权限，则初始化设置信息
        if (mHasAllPermissions) {
            RyxApplication.getInstance().initDeviceAndApp();
            view.showVersionName(getVersionName());
        }

        //去数据库取一份UserInfo
        String userId = PreferencesUtils.getString(view.getContext(), PreferencesKey.USER_ID, "");
        if (!StringUtils.isBlank(userId)) {
            final UserInfo userInfo = RyxApplication.getInstance().mAccountManager.getAccountFromDB(userId);
            if (userInfo != null) {
                RyxApplication.getInstance().setUserInfo(userInfo);

            }
        }



        view.goNextPage();
    }

    public String getVersionName() {
        if (mAppInfo != null) {
            String versionName = mAppInfo.versionName;
            String appName = mAppInfo.appName;
            return appName + "V" + versionName;
        }
        return "";
    }
}
