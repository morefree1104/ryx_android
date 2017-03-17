package com.ryx.ryx.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.neo.duan.entity.base.BaseInfo;
import com.neo.duan.ui.adapter.base.base.entity.MultiItemEntity;

/**
 * @author : joy.hu
 * @date : 	 2017/3/14
 * @desc : 用户信息实体
 */
public class TestInfo extends BaseInfo {
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}

