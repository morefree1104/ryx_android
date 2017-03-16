package com.ryx.ryx.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.utils.ToastUtil;
import com.ryx.ryx.R;
import com.ryx.ryx.manager.IntentManager;
import com.ryx.ryx.ui.activity.base.BaseActivity;

import butterknife.OnClick;
import butterknife.OnFocusChange;

public class LoginActivity extends BaseActivity {


    @Override
    public void initTop() {
        enableTitle(true,"登录", com.neo.duan.R.color.common_black);
        enableBack(true,"返回");

    }

    @Override
    public void initLayouts() {setContentView(R.layout.activity_login);

    }

    @Override
    public void initViews() {

    }

    @Override
    public BasePresenter initPresents() {
        return null;
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initData() {

    }
    /**
     * 点击注册
     * @param view
     */
    @OnClick(R.id.lg_tv_register)
    public void onClickregister(View view) {
        IntentManager.getInstance().goRegisterActivity(mContext);
    }

    /**
     * 点击找回密码
     * @param view
     */
    @OnClick(R.id.tv_forget_password)
    public void onClickforgetpassword(View view) {
        IntentManager.getInstance().goRetrieveActivity(mContext);
    }


}
