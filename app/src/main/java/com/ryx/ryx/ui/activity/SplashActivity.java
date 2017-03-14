package com.ryx.ryx.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.neo.duan.ui.widget.app.XTextView;
import com.neo.duan.utils.constants.Constants;
import com.neo.duan.utils.preferences.PreferencesUtils;
import com.ryx.ryx.R;
import com.ryx.ryx.manager.IntentManager;
import com.ryx.ryx.mvp.contract.SplashContract;
import com.ryx.ryx.mvp.present.SplashPresenterImpl;
import com.ryx.ryx.ui.activity.base.BaseActivity;

import butterknife.BindView;

/**
 * @author : neo.duan
 * @date : 	 2016/7/25 0025
 * @desc : Splash页面
 */
public class SplashActivity extends BaseActivity<SplashContract.Presenter> implements SplashContract.View {

    private static final int REQUEST_CODE = 0; // 请求码

    @BindView(R.id.tv_splash_version)
    XTextView mTvVersion;

    @Override
    public void initTop() {
        enableTop(false);
    }

    @Override
    public void initLayouts() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initViews() {
    }

    @Override
    public SplashContract.Presenter initPresents() {
        return new SplashPresenterImpl(this);
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initData() {

    }

    /**
     * 显示时候：判断6.0权限问题，然后初始化系统设备信息等
     */
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.checkPermissions();
    }

    @Override
    public void showVersionName(String version) {
        mTvVersion.setText(version);
    }

    @Override
    public void goNextPage() {
        //显示后，2s钟进入下一页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                IntentManager.getInstance().goMainActivity(mContext);
                closeActivity();
            }
        }, 2000);
    }

    @Override
    public void goPermissionsActivity() {
        IntentManager.getInstance().goPermissionsActivity(this, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            closeActivity();
        } else {
            //同意授权
            mPresenter.setHasAllPermissions(true);
        }
    }
}
