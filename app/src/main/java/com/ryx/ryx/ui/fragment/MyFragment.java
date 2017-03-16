package com.ryx.ryx.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;

import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.ui.widget.recyclerview.DividerGridItemDecoration;
import com.neo.duan.ui.widget.recyclerview.XRecyclerView;
import com.ryx.ryx.R;
import com.ryx.ryx.manager.IntentManager;
import com.ryx.ryx.ui.adapter.Myadapter;
import com.ryx.ryx.ui.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;


public class MyFragment extends BaseFragment{
    @BindView(R.id.rlv_share)
    XRecyclerView mRecyclerView;
    private Myadapter mAdapter;

    @Override
    public void initTop() {
        enableTitle(true,"我的",com.neo.duan.R.color.common_black);
        enableBack(false);
        enableRightNav(true,"设置",com.neo.duan.R.color.common_black);
    }

    @Override
    public void initLayouts() {setContentView(R.layout.fragment_my);

    }

    @Override
    public void initViews() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(mContext, R.drawable.line_divider));


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
    /*
    * 完善个人信息
    * @param view
    */
    @OnClick(R.id.rl_top)
    public void onClickrltop(View view) {
        IntentManager.getInstance().goInfoActivity(mContext);
    }

    /**
     * 点击登录
     * @param view
     */
    @OnClick(R.id.tv_login)
    public void onClickLogin(View view) {
        IntentManager.getInstance().goLoginActivity(mContext);
    }
    /**
     * 点击注册
     * @param view
     */
    @OnClick(R.id.tv_register)
    public void onClickregister(View view) {
        IntentManager.getInstance().goRegisterActivity(mContext);
    }
}
