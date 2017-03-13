package com.ryx.ryx.ui.fragment.base.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.ui.fragment.base.AppBaseFragment;

import butterknife.ButterKnife;

/**
 * @author : neo.duan
 * @date : 	 2016/9/19 0019
 * @desc : 请描述该文件
 */
public abstract class BaseFragment<P extends BasePresenter> extends AppBaseFragment<P> {

    protected boolean mHidden;

    @Override
    public void setContentView(View contentView) {
        super.setContentView(contentView);
        //绑定findViewById框架
        ButterKnife.bind(this, mContentView);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.mHidden = hidden;
    }

    public void addFragment(int containerId, Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getChildFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerId, fragment);
        transaction.commit();
    }
}
