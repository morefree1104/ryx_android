package com.neo.duan.manager;


import android.app.Activity;
import android.os.Looper;

import com.orhanobut.logger.Logger;

/**
 * @author : neo.duan
 * @date : 	 2016/8/17
 * @desc : 全局异常捕获
 */
public class ExceptionManager implements Thread.UncaughtExceptionHandler {
    private static final String TAG = ExceptionManager.class.getSimpleName();
    private ExceptionManager() {
        //初始化bugly,设置appId和日志开关
//        CrashReport.initCrashReport(TTBuyApplication.getInstance(), "25b1ebeddb", BuildConfig.DEBUG);
    }

    public static final ExceptionManager getInstance() {
        return ExceptionManagerHolder.instance;
    }
    private static class ExceptionManagerHolder {
        private static final ExceptionManager instance = new ExceptionManager();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //上报异常
        reportException(thread,ex);
        //弹出对话框提示
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Activity activity = ScreenManager.getInstance().currentActivity();
                if (activity == null) {
                    killProcess();
                } else {
                    showDialog(activity);
                }
                Looper.loop();
            }
        }.start();
    }

    private void showDialog(final Activity activity) {
//        if (activity != null) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.MyAlertDialogStyle);
//            builder.setTitle("提示");
//            builder.setMessage("程序崩溃了");
//            builder.setCancelable(false);
//            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Intent intent = new Intent(activity, MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    IntentManager.getInstance().goActivity(activity,intent);
//                    killProcess();
//                }
//            });
//            builder.show();
//        }
    }

    private void killProcess() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 上报异常
     * @param thread
     * @param ex
     */
    public void reportException(Thread thread, Throwable ex) {
        if (ex != null) {
            ex.printStackTrace();
            Logger.e(TAG, ex.getMessage());
        }
        //TODO 采用bugly
//        CrashReport.postCatchedException(ex);
    }
}
