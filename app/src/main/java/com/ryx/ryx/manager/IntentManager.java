package com.ryx.ryx.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;

import com.neo.duan.event.base.EventCode;
import com.neo.duan.utils.ListUtils;
import com.neo.duan.utils.StringUtils;
import com.neo.duan.utils.constants.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @author : neo.duan
 * @date : 	 2016/7/25 0025
 * @desc : Activity的跳转管理器
 */
public class IntentManager {
    private final String TAG = "IntentManager";

    public static final int EDIT_ACTIVITY = 888;

    private IntentManager() {
    }

    public static final IntentManager getInstance() {
        return IntentManagerHolder.instance;
    }

    private void startActivity(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        context.startActivity(intent);
        //界面跳转动画
//        if (context instanceof Activity) {
//            ((Activity) context).overridePendingTransition(R.anim.anim_push_left_in,
//                    R.anim.anim_push_left_out);
//        }
    }

    private void startActivity(Context context, Class clz) {
        startActivity(context, new Intent(context, clz));
    }

    private void startAcitivityForResult(Activity context, Intent intent,
                                         int requestCode) {
        if (context == null) {
            return;
        }
        context.startActivityForResult(intent, requestCode);
    }

    public void goActivity(Context context, Intent intent) {
        startActivity(context, intent);
    }


    /**
     * 开启摄像头
     *
     * @param activity
     * @param requestCode :请求码，用于返回Activity的时候做识别
     */
    public void openCamera(Activity activity, int requestCode) {
        String currentTime = String.valueOf(System.currentTimeMillis());
        int hashCode = currentTime.hashCode();
        String cameraImageAddress = String.valueOf(hashCode);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // 调用系统相机

        String imageCacheFile = Environment.getExternalStorageDirectory().getPath() + "/" + Constants.PROJECT + "/";
        Uri imageUri = Uri.fromFile(new File(imageCacheFile, "image" + cameraImageAddress + ".jpg"));

        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        activity.startActivityForResult(intent, requestCode);
    }


    private static class IntentManagerHolder {
        private static final IntentManager instance = new IntentManager();
    }


}