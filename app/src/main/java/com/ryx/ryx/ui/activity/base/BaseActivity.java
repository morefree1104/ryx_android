package com.ryx.ryx.ui.activity.base;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.view.View;

import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.ui.activity.base.AppBaseActivity;
import com.neo.duan.utils.LogUtils;

import butterknife.ButterKnife;

/**
 * @author : neo.duan
 * @date : 	 2016/9/19
 * @desc : 请描述这个文件
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppBaseActivity<P> {

    private ProgressDialog mLoadingDialog;

    @Override
    public void setContentView(View contentView) {
        super.setContentView(contentView);
        //绑定findViewById框架
        ButterKnife.bind(this, mContentView);
    }

    @Override
    public void showLoading() {
        showLoading("");
    }

    @Override
    public void showLoading(String msg) {
        if (mLoadingDialog == null) {
            mLoadingDialog = new ProgressDialog(mContext);
            mLoadingDialog.setCanceledOnTouchOutside(false);
        }
        mLoadingDialog.setMessage(msg);
        mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (!isFinishing() && mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    public void addFragment(int containerId, Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerId, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("Activity", "current activity = " + TAG);
    }
}
