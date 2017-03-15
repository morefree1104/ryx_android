package com.ryx.ryx.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.neo.duan.ui.adapter.base.XBaseAdapter;
import com.neo.duan.ui.adapter.base.XBaseViewHolder;
import com.ryx.ryx.R;

import java.util.ArrayList;

import static com.neo.duan.AppBaseApplication.mDeviceInfo;

/**
 * Created by Administrator on 2017/3/14 0014.
 */

public class Myadapter extends XBaseAdapter<Integer> {
    private static final String[] strArr = {
            "我的课程",
            "我的关注",
            "我的收藏",
            "我的离线"
    };

    private static final int[] resArr = {
            R.mipmap.kechenng_01,
            R.mipmap.guanzhu_01,
            R.mipmap.shoucang_01,
            R.mipmap.lixian_01
    };

    public Myadapter(Context context) {
        super(context);
        this.mData = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            mData.add(i);
        }
    }
    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        View itemView = mLayoutInflater.inflate(layoutResId, parent, false);
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        params.width = mDeviceInfo.screenWith / 4;
        params.height = params.width ;
        return itemView;
    }
    @Override
    protected void convert(XBaseViewHolder holder, final Integer integer) {
        holder.setImageResource(R.id.iv_share_item, resArr[integer]);
        holder.setText(R.id.tv_share_item, strArr[integer]);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_my;
    }
    @Override
    public int getItemCount() {
        return strArr.length;
    }
}
