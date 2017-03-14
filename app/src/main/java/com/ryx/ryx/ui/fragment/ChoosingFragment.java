package com.ryx.ryx.ui.fragment;

import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.fragment.base.BaseFragment;



public class ChoosingFragment extends BaseFragment{
    @Override
    public void initTop() {
        enableTop(true);
        enableBack(false);
        enableTitle(true,"选课");


    }

    @Override
    public void initLayouts() {
        setContentView(R.layout.fragment_choosing);

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