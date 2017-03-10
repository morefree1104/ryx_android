package com.ryx.ryx.db.impl;

import android.content.Context;

import com.neo.duan.db.base.BaseDaoImpl;
import com.ryx.ryx.db.UserDao;
import com.ryx.ryx.entity.UserInfo;


/**
 * @author : neo.duan
 * @date : 	 2016/9/12
 * @desc : 请描述该文件
 */
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements UserDao {
    public UserDaoImpl(Context context) {
        super(context);
    }
}
