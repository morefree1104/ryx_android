package com.ryx.ryx.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.activity.base.BaseActivity;

public class RetrieveActivity extends BaseActivity{


    @Override
    public void initTop() {
        enableTitle(true,"找回密码", com.neo.duan.R.color.common_black);
        enableBack(true,"返回");
    }

    @Override
    public void initLayouts() {setContentView(R.layout.activity_retrieve);

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
