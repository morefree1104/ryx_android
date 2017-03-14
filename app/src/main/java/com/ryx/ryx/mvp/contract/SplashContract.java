package com.ryx.ryx.mvp.contract;

import com.neo.duan.mvp.interactor.BaseInteractor;
import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.mvp.view.base.IBaseView;

/**
 * @author : neo.duan
 * @date : 	 2016/10/8
 * @desc : 闪屏页
 */
public interface SplashContract {
    interface View extends IBaseView {

        /**
         * 显示版本号
         * @param version
         */
        void showVersionName(String version);

        /**
         * 跳转到下个界面
         */
        void goNextPage();

        /**
         * 跳转到权限授权页面
         */
        void goPermissionsActivity();
    }

    interface Presenter extends BasePresenter {

        void setHasAllPermissions(boolean hasAllPermissions);

        /**
         * 校验权限，适配6.0权限问题
         */
        void checkPermissions();
    }

    interface Interactor extends BaseInteractor {

    }
}
