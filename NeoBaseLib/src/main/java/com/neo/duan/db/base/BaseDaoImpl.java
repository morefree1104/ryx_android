package com.neo.duan.db.base;

import android.content.Context;
import android.text.TextUtils;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.neo.duan.utils.LogUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/9/12
 * @desc : 通用的实体操作实现基类
 */
public abstract class BaseDaoImpl<M> implements DAO<M> {
    protected final String TAG = getClass().getSimpleName();
    public Dao dao = null;
    public OrmLiteSqliteOpenHelper helper = null;

    public BaseDaoImpl(Context context) {
        helper = OpenHelperManager.getHelper(context, DBHelper.class);
        try {
            M m = getInstance();
            dao = helper.getDao(m.getClass());
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(TAG, "获取Dao失败", e);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        OpenHelperManager.releaseHelper();//释放掉helper
        super.finalize();
    }

    @Override
    public boolean insert(M m) {
        if (m == null) {
            LogUtils.e(TAG, "insert object is empty");
            return false;
        }
        try {
            Dao.CreateOrUpdateStatus orUpdate = dao.createOrUpdate(m);
            return orUpdate.isCreated() && orUpdate.getNumLinesChanged() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(M m) {
        if (m == null) {
            LogUtils.e(TAG, "delete object is empty");
            return false;
        }
        try {
            return dao.delete(m) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        if (TextUtils.isEmpty(id)) {
            LogUtils.e(TAG, "deleteById id is empty");
            return false;
        }
        try {
            return dao.deleteById(id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(M m) {
        if (m == null) {
            LogUtils.e(TAG, "update object is empty");
            return false;
        }
        try {
            return dao.update(m) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<M> getAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public M get(String id) {
        try {
            return (M) dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void clear() {
        try {
            int delete = dao.deleteBuilder().delete();
            LogUtils.d(TAG, "delete count = " + delete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取泛型实例
     *
     * @return
     */
    public M getInstance() {
        // 获取NewsDaoImpl（子类）
        Class clazz = super.getClass();
        // 获取支持泛型的父类
        Type type = clazz.getGenericSuperclass();
        // 获取支持泛型的父类里面传递的参数
        if (type instanceof ParameterizedType) {
            Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
            Class c = (Class) arguments[0];
            try {
                // 创建实例
                return (M) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
