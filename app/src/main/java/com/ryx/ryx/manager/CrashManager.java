package com.ryx.ryx.manager;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.neo.duan.manager.ScreenManager;
import com.ryx.ryx.ui.activity.MainActivity;

/**
 * @author : neo.duan
 * @date : 	 2016/8/17
 * @desc : 全局崩溃处理
 */
public class CrashManager implements Thread.UncaughtExceptionHandler {
    private static final String TAG = CrashManager.class.getSimpleName();

    private CrashManager() {

    }

    public static final CrashManager getInstance() {
        return CrashManagerHolder.instance;
    }

    private static class CrashManagerHolder {
        private static final CrashManager instance = new CrashManager();
    }

    public void init() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e(TAG,"崩溃日志:",ex);
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                showCrashDialog();
                Looper.loop();
            }
        }.start();
    }

    private void showCrashDialog() {
        final Activity topActivity = ScreenManager.getInstance().currentActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(topActivity);
        builder.setTitle("程序崩溃");
        builder.setMessage("请检查该功能是否已开发,通过tag:CrashManager查看该崩溃日志");
        builder.setPositiveButton("我去检查", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ScreenManager.getInstance().popAllActivity();
                Intent intent = new Intent(topActivity, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                IntentManager.getInstance().goActivity(topActivity,intent);
                killProcess();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void killProcess() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
