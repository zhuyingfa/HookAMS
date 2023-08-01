package com.yvan.hookams;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * @author yvan
 * @date 2023/7/28
 * @description
 */
public class HookAMSApplication extends Application {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();
        handler.post(this::hookAMS);
    }

    public void hookAMS() {
        try {
            HookAMSUtils hookUtils = new HookAMSUtils(this, ProxyActivity.class);
            hookUtils.hookAms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
