package com.neo.duan.ui.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.neo.duan.R;
import com.neo.duan.ui.adapter.base.base.BaseQuickAdapter;
import com.neo.duan.ui.adapter.base.base.BaseViewHolder;
import com.neo.duan.utils.constants.Constants;

import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/9/15
 * @desc : 应用再封装BaseQuickAdapter库
 */
public abstract class XBaseAdapter<T> extends BaseQuickAdapter<T> {

    public XBaseAdapter(Context context) {
        super(null);
        this.mContext = context;
        this.mLayoutResId = getLayoutResId(0);
        openLoadMore(Constants.PAGE_SIZE);
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
    public void loadComplete() {
        super.loadComplete();
        removeAllFooterView();
        addFooterView(View.inflate(mContext, R.layout.layout_no_more, null));
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
