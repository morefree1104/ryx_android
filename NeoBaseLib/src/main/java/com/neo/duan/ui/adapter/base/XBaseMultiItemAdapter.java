package com.neo.duan.ui.adapter.base;

import android.content.Context;
import android.view.ViewGroup;

import com.neo.duan.ui.adapter.base.base.BaseMultiItemQuickAdapter;
import com.neo.duan.ui.adapter.base.base.BaseViewHolder;
import com.neo.duan.ui.adapter.base.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/9/16
 * @desc : 请描述这个文件
 */
public abstract class XBaseMultiItemAdapter<T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T>{

    public XBaseMultiItemAdapter(Context context) {
        super(null);
        this.mContext = context;
        this.mLayoutResId = getLayoutResId(0);
    }

    public void addData(T t) {
        if (t != null) {
            mData.add(t);
        }
        notifyItemInserted(mData.size() - 1);
    }

    public void update(List<T> list) {
        setNewData(list);
    }

    public void remove(T t) {
        if (t != null && mData.contains(t)) {
            remove(mData.indexOf(t));
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mLayoutResId = getLayoutResId(viewType);
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        convert((XBaseViewHolder) helper,item);
    }


    protected abstract void convert(XBaseViewHolder holder, T item);

    protected abstract int getLayoutResId(int viewType);
}
