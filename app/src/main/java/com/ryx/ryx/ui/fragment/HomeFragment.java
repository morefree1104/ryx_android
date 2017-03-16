package com.ryx.ryx.ui.fragment;



import com.neo.duan.mvp.present.BasePresenter;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.fragment.base.BaseFragment;

public class HomeFragment extends BaseFragment{
    @Override
    public void initTop() {
        enableTitle(true,"融易学", com.neo.duan.R.color.common_white);
        setTopBarBackground(com.neo.duan.R.color.orange);
        enableBack(true,R.mipmap.white_search_02);
        enableRightNav(true,R.mipmap.white_youxiang);


    }

    @Override
    public void initLayouts() {setContentView(R.layout.fragment_home);

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