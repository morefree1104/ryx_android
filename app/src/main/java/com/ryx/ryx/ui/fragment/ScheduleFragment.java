package com.ryx.ryx.ui.fragment;

import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.ui.fragment.base.fragment.BaseFragment;


public class ScheduleFragment extends BaseFragment {

    @Override
    public void initTop() {
        enableTop(true);
        enableBack(false);
        enableTitle(true,"课表");
     enableRightNav(true, R.mipmap.youxiang_01);

    }

    @Override
    public void initLayouts() {setContentView(R.layout.fragment_schedule);

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
