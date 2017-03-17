package com.ryx.ryx.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bigkoo.pickerview.OptionsPickerView;
import com.neo.duan.mvp.present.BasePresenter;
import com.neo.duan.ui.widget.MainNavTabBarView;
import com.ryx.ryx.MockService;
import com.ryx.ryx.R;
import com.ryx.ryx.ui.activity.base.BaseActivity;
import com.ryx.ryx.ui.fragment.ChoosingFragment;
import com.ryx.ryx.ui.fragment.HomeFragment;
import com.ryx.ryx.ui.fragment.MyFragment;
import com.ryx.ryx.ui.fragment.ScheduleFragment;
import com.ryx.ryx.ui.popupwindow.OptionPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainNavTabBarView.OnTabSelectedListener {
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;
    private HomeFragment mHomeFragment;//首页
    private ChoosingFragment mChoosingFragment;//选课
    private ScheduleFragment mScheduleFragment;    //课表
    private MyFragment mMyFragment;  //我的

    private List<String> mFragmentTags = new ArrayList<>();

    @BindView(R.id.main_tab_bar)
    MainNavTabBarView mTabBar;


    @Override
    public void initTop() {
//        enableTop(true, com.neo.duan.R.color.orange);
        enableTop(false);
    }

    @Override
    public void initLayouts() {
        setContentView(R.layout.activity_main);

    }

    @Override
    public void initViews() {
        mFragmentManager = getSupportFragmentManager();
    }


    @Override
    public BasePresenter initPresents() {
        return null;
    }

    @Override
    public void initListeners() {
        mTabBar.setOnTabSelectedListener(this);
    }

    @Override
    public void initData() {
        mTabBar.setItemSelected(0);
    }

    /**
     * 底部导航切换回调
     */
    @Override
    public void onTabSelected(int position) {
        //控制当前显示哪个fragment
        String fragmentTag = "";
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                fragmentTag = HomeFragment.class.getSimpleName();
                mCurrentFragment = mHomeFragment;
                break;
            case 1:
                if (mChoosingFragment == null) {
                    mChoosingFragment = new ChoosingFragment();
                }
                fragmentTag = ChoosingFragment.class.getSimpleName();
                mCurrentFragment = mChoosingFragment;
                break;
            case 2:
                if (mScheduleFragment == null) {
                    mScheduleFragment = new ScheduleFragment();
                }
                fragmentTag = ScheduleFragment.class.getSimpleName();
                mCurrentFragment = mScheduleFragment;
                break;
            case 3:
                if (mMyFragment == null) {
                    mMyFragment = new MyFragment();
                }
                fragmentTag = MyFragment.class.getSimpleName();
                mCurrentFragment = mMyFragment;
                break;
            default:
                break;
        }

        if (!mFragmentTags.contains(fragmentTag)) {
            mFragmentTags.add(fragmentTag);
        }

        //检查mFragmentManager是否添加，未添加则添加
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        //设置显示动画
//        transaction.setCustomAnimations(R.anim.slide_in_from_right,R.anim.slide_out_from_left);
        Fragment tagFragment = mFragmentManager.findFragmentByTag(fragmentTag);
        if (tagFragment == null || tagFragment != mCurrentFragment) {
            //移除掉以前的废弃的，因为程序崩溃该Manager还保存着以前销毁View的Fragment
            if (tagFragment != null) {
                transaction.remove(tagFragment);
            }
            transaction.add(R.id.fl_main_container, mCurrentFragment, fragmentTag);
        }

        List<Fragment> fragmentList = mFragmentManager.getFragments();
        if (fragmentList != null && fragmentList.size() > 0) {
            for (int i = 0; i < fragmentList.size(); i++) {
                for (String tag : mFragmentTags) {
                    Fragment cacheTagFragment = mFragmentManager.findFragmentByTag(tag);
                    if (cacheTagFragment == null || cacheTagFragment == mCurrentFragment) {
                        continue;
                    }
                    transaction.hide(cacheTagFragment);
                }
            }
        }
        //显示当前，其他隐藏
        transaction.show(mCurrentFragment);
        transaction.commitAllowingStateLoss();
        //测试代码
        //显示弹出框
//        testOptionPop();
        //显示加载中框
//        showLoading();
    }

    //弹出框用法
    public void testOptionPop(){
        //初始化弹出框
        final OptionPop pop = new OptionPop(mContext);
        //设置弹出框标题
        pop.setTitle("行业选择");
        //设置参数值
        pop.setPicker(MockService.mockIndustry());
        //设置是否循环
        pop.setCyclic(false);
        //设置点击确认后的监听事件
        pop.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                pop.setSelectOptions(options1);
            }
        });
        //显示弹出框
        pop.show();
    }
}