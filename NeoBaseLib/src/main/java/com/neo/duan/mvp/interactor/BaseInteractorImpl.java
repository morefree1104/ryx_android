package com.neo.duan.mvp.interactor;

import com.neo.duan.net.handler.HttpHandler;
import com.neo.duan.net.http.HttpLoader;
import com.neo.duan.net.listener.base.IHttpListener;
import com.neo.duan.net.request.base.BaseRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/7/26 0026
 * @desc : 请描述该文件
 */
public class BaseInteractorImpl implements BaseInteractor{
    private final List<BaseRequest> mReqList = new ArrayList<>();

    public void sendRequest(BaseRequest request, IHttpListener listener) {
        HttpHandler handler = new HttpHandler(request,listener,0);
        mReqList.add(handler.getRequest());
        HttpLoader.getInstance().sendRequest(handler);
    }

    @Override
    public void onDestroy() {
        for (BaseRequest req : mReqList) {
            HttpLoader.getInstance().cancel(req);
        }
    }
}
