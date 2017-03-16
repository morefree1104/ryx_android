package com.ryx.ryx.ui.fragment;

import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.fragment.base.BaseFragment;


public class ScheduleFragment extends BaseFragment {

    @Override
    public void initTop() {
        enableTop(true);
        enableBack(false);
        enableTitle(true,"我的课表", com.neo.duan.R.color.common_black);

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
