package com.ryx.ryx.ui.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.activity.base.BaseActivity;

import butterknife.BindView;

public class RetrieveActivity extends BaseActivity{
    @BindView(R.id.rl_verification)
    RelativeLayout relativeLayout;
    @BindView(R.id.et_verification)
    EditText etverification;

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
        etverification.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //根据edittext焦点情况，切换父元素的背景
                if(hasFocus){
                    relativeLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_et_style));
                }else{
                    relativeLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_et_normal));
                }
            }
        });

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
