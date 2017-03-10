package com.neo.duan.utils.preferences;

import android.content.Context;

import com.neo.duan.utils.constants.Constants;


/**
 * @author : neo.duan
 * @date : 	 2016/7/25
 * @desc : preferences操作工具类
 */
public class PreferencesUtils extends BasePreferences {
    // 文件名
    private static final String PREFERENCES_NAME = Constants.PROJECT;
    private static final String KEY_USER_ID = "userId";


    private PreferencesUtils() {
        throw new AssertionError();
    }

    /**
     * 保存数据
     *
     * @param key
     * @return boolean true:成功 false:失败
     */
    public static boolean putData(Context context, String key, Object value) {
        return saveData(context, PREFERENCES_NAME, key, value);
    }

    /**
     * 从文件中获取数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static Object getData(Context context, String key, Object defValue) {
        if (context == null) {
            return defValue;
        }
        return getData(context, PREFERENCES_NAME, key, defValue);
    }

    /**
     * 移除指定KEY
     *
     * @param key
     */
    public static void removeKey(Context context, String key) {
        remove(context, PREFERENCES_NAME, key);
    }

    /**
     * 清除所有数据
     */
    public static void clear(Context context) {
        clear(context, PREFERENCES_NAME);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        putData(context, key, value);
    }

    public static void putInt(Context context, String key, int value) {
        putData(context, key, value);
    }

    public static void putString(Context context, String key, String value) {
        putData(context, key, value);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return (Boolean) getData(context, key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        return (Integer) getData(context, key, defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        return (String) getData(context, key, defValue);
    }

}
