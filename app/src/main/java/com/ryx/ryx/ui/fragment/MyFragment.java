package com.ryx.ryx.ui.fragment;

import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.ui.fragment.base.fragment.BaseFragment;


public class MyFragment extends BaseFragment{

    @Override
    public void initTop() {
        enableTop(true);
        enableBack(false);
        enableTitle(true,"我的");
        enableRightNav(true,"设置");
    }

    @Override
    public void initLayouts() {setContentView(R.layout.fragment_my);

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
