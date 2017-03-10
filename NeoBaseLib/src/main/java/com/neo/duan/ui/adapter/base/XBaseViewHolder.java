package com.neo.duan.ui.adapter.base;

import android.view.View;

import com.neo.duan.ui.adapter.base.base.BaseViewHolder;
import com.neo.duan.ui.widget.app.XImageView;

/**
 * @author : neo.duan
 * @date : 	 2016/9/15
 * @desc : 再次封装BaseViewHolder
 */
public class XBaseViewHolder extends BaseViewHolder{

    public XBaseViewHolder(View view) {
        super(view);
    }

    /**
     * 设置图片url
     * @param viewId
     * @param url
     * @return
     */
    public BaseViewHolder setImageUrl(int viewId, String url) {
        XImageView imageView = getView(viewId);
        if (imageView != null) {
            imageView.setImageUrl(url);
        }
        return this;
    }
}
