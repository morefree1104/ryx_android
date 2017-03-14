package com.neo.duan.net.request.base;

import com.alibaba.fastjson.JSON;
import com.neo.duan.AppBaseApplication;
import com.neo.duan.entity.base.BaseInfo;
import com.neo.duan.utils.LogUtils;
import com.neo.duan.utils.SHA;
import com.neo.duan.utils.StringUtils;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : neo.duan
 * @date : 	 2016/7/26 0026
 * @desc : 各个请求基类
 */
public abstract class BaseRequest {
    private static final String TAG = BaseRequest.class.getSimpleName();

    private String nonce;

    public String getNonce() {
        return nonce;
    }

    public Map<String, Object> params = new HashMap<>();

    public abstract String getApi();

    public void add(String param, Object paramValue) {
        params.put(param.trim(), paramValue);
    }

    public Map<String, Object> getParams() {
//        return handleCommonParams();
        //TODO 加上签名
        return params;
    }


    /**
     * 添加公共参数
     */
    private Map<String, Object> handleCommonParams() {
        //组装请求参数
        Map<String, Object> commParams = new HashMap<>();
        commParams.put("Nonce", generateUUID().trim());
        commParams.put("Timestamp", System.currentTimeMillis());
        commParams.put("MethodName", getApi().trim());

        if (!StringUtils.isBlank(AppBaseApplication.mToken)) {
            params.put("Token", AppBaseApplication.mToken);
        }
        commParams.put("RequestData", JSON.toJSON(params).toString().trim());

//        LogUtils.d(TAG, "map to json:" + JSON.toJSON(params));

        //对参数签名
//        String sign = "";
//        try {
//            //参数再拼接key
//            sign = SHA.getSHA(getParamsString(commParams)).toUpperCase();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        commParams.put("Sign", sign);
        return commParams;
    }

    private String getParamsString(Map<String, Object> map) {
        //map无序，但请求String需要按顺序拼接
        StringBuilder builder = new StringBuilder();
        builder.append("Nonce" + "="+ map.get("Nonce") + "&");
        builder.append("Timestamp" + "="+ map.get("Timestamp") + "&");
        builder.append("MethodName" + "="+ map.get("MethodName") + "&");
        builder.append("RequestData" + "="+ map.get("RequestData"));

        String paramString = builder.toString().trim();

        LogUtils.d(TAG, " param String :"  + paramString);
        return paramString;
    }

    /**
     * 生成UUID
     * @return
     */
    private String generateUUID() {
        this.nonce = UUID.randomUUID().toString();
        return nonce;
    }

    public abstract Class<? extends BaseInfo> getResponseClazz();
}
