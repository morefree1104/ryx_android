package com.ryx.ryx.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.ui.widget.CommonTitleBarView;
import com.ryx.ryx.R;
import com.ryx.ryx.manager.IntentManager;
import com.ryx.ryx.ui.activity.base.BaseActivity;

public class RegisterActivity extends BaseActivity{


    @Override
    public void initTop() {
        enableTitle(true,"融易学", com.neo.duan.R.color.common_black);
        enableBack(true,"返回");
        enableRightNav(true,"登录",com.neo.duan.R.color.common_black);
        setOnNavRightListener(new CommonTitleBarView.OnNavRightListener() {
            @Override
            public void onNavRight() {
                IntentManager.getInstance().goLoginActivity(mContext);
            }
        });
    }

    @Override
    public void initLayouts() {setContentView(R.layout.activity_register);

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
}
