package com.neo.duan.db.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.neo.duan.AppBaseApplication;
import com.neo.duan.utils.LogUtils;
import com.neo.duan.utils.constants.Constants;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : neo.duan
 * @date : 	  2016/9/12
 * @desc :
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DBHelper.class.getSimpleName();

    private Map<Class<?>, Dao<?, Integer>> daoMap;

    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        daoMap = new HashMap<>();
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            LogUtils.d(TAG, "create user table");
            List<Class> tableClzList = AppBaseApplication.mTableClzList;
            for (Class clz : tableClzList) {
                TableUtils.createTable(connectionSource, clz);
            }
        } catch (SQLException e) {
            LogUtils.e(TAG, "create database error", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int arg2,
                          int arg3) {
        try {
            List<Class> tableClzList = AppBaseApplication.mTableClzList;
            for (Class clz : tableClzList) {
                TableUtils.dropTable(connectionSource, clz, true);
            }
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
            LogUtils.e(TAG, "updateShowList database error", e);
        }
    }

    @Override
    public <D extends Dao<T, ?>, T> D getDao(Class<T> clazz)
            throws SQLException {
        if (daoMap.containsKey(clazz)) {
            return (D) daoMap.get(clazz);
        } else {
            Dao<T, Integer> dao = super.getDao(clazz);
            daoMap.put(clazz, dao);
            return (D) dao;
        }
    }

    @Override
    public void close() {
        super.close();
        daoMap.clear();
    }
}
