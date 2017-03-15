package com.ryx.ryx.ui.fragment;

import android.support.v7.widget.GridLayoutManager;

import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.ui.widget.recyclerview.XRecyclerView;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.adapter.Myadapter;
import com.ryx.ryx.ui.fragment.base.BaseFragment;

import butterknife.BindView;


public class MyFragment extends BaseFragment{
    @BindView(R.id.rlv_share)
    XRecyclerView mRecyclerView;
    private Myadapter mAdapter;

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
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));


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
        mRecyclerView.setAdapter(mAdapter = new Myadapter(mContext));

    }
}
