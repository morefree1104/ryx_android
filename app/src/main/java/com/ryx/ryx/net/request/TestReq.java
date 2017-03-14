package com.ryx.ryx.net.request;

import com.neo.duan.entity.base.BaseInfo;
import com.neo.duan.net.request.base.BaseRequest;
import com.ryx.ryx.entity.TestInfo;
import com.ryx.ryx.utils.constants.API;

/**
 * 会员请求加入群组
 */
public class TestReq extends BaseRequest {

    public TestReq() {
    }
    @Override
    public String getApi() {
        return API.TEST;
    }

    @Override
    public Class<? extends BaseInfo> getResponseClazz() {
        return TestInfo.class;
    }
}
