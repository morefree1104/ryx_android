package com.ryx.ryx.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.neo.duan.entity.base.BaseInfo;
import com.neo.duan.ui.adapter.base.base.entity.MultiItemEntity;
import com.neo.duan.utils.StringUtils;

/**
 * @author : neo.duan
 * @date : 	 2016/9/12
 * @desc : 用户信息实体
 */
@DatabaseTable(tableName = "user_info")
public class UserInfo extends BaseInfo implements MultiItemEntity, Parcelable{
    //用户唯一标识id
    public static final String _ID = "_id";


    //预留字段:用于数据库
    public static final String DATA0 = "_data0";
    public static final String DATA1 = "_data1";
    public static final String DATA2 = "_data2";
    public static final String DATA3 = "_data3";
    public static final String DATA4 = "_data4";
    public static final String DATA5 = "_data5";
    public static final String DATA6 = "_data6";
    public static final String DATA7 = "_data7";

    //一定要有无参数构造方法
    public UserInfo() {
    }

    @DatabaseField(id = true, columnName = _ID)
    @JSONField(name = "UserId")
    private String userId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
    }

    protected UserInfo(Parcel in) {
        this.userId = in.readString();
    }


    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    @Override
    public int getItemType() {
        return 0;
    }
}

