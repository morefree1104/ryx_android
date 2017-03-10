package com.neo.duan.mvp.present;


import com.neo.duan.mvp.interactor.BaseInteractor;
import com.neo.duan.mvp.view.base.IBaseView;

/**
 * @author : neo.duan
 * @date : 	 2016/8/16 0016
 * @desc : 各个presenter实现基类
 */
public abstract class BasePresenterImpl<V extends IBaseView, M extends BaseInteractor> implements BasePresenter {
    protected V view;
    protected M interactor;

    public BasePresenterImpl(V view) {
        this.view = view;
        setInteractor();
    }

    private void setInteractor() {
        this.interactor = initInteractor();
    }

    public abstract M initInteractor();

    @Override
    public void onDestroy() {
        if (view != null) {
            view = null;
        }
        if (interactor != null) {
            interactor.onDestroy();
            interactor = null;
        }
    }
}
