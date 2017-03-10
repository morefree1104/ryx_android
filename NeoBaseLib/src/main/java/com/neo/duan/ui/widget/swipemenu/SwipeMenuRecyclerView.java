package com.neo.duan.ui.widget.swipemenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.neo.duan.ui.widget.recyclerview.XRecyclerView;

/**
 * @author : neo.duan
 * @date : 	 2016/9/16
 * @desc : 滑动删掉RecyclerView
 */
public class SwipeMenuRecyclerView extends XRecyclerView implements SwipeMenuHelper.Callback{

    protected SwipeMenuHelper mHelper;

    public SwipeMenuRecyclerView(Context context) {
        super(context);
        init();
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        mHelper = new SwipeMenuHelper(getContext(), this);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercepted = super.onInterceptTouchEvent(ev);
        // ignore Multi-Touch
        if (ev.getActionIndex() != 0) return true;
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isIntercepted = mHelper.handleLvDownTouchEvent(ev, isIntercepted);
                break;
        }
        return isIntercepted;
    }

    public int getPositionForView(View touchView) {
        return getChildAdapterPosition(touchView);
    }

    @Override
    public View transformTouchingView(int touchingPosition, View touchingView) {
        ViewHolder vh = findViewHolderForAdapterPosition(touchingPosition);
        if (vh != null) {
            return vh.itemView;
        }
        return touchingView;
    }
}
