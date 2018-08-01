package com.component.activity;

import com.acmenxd.frame.basis.FrameApplication;

public abstract class BaseApp extends FrameApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    // 单例实例
    private static BaseApp sInstance = null;

    public BaseApp() {
        sInstance = this;
    }

    public static synchronized BaseApp getInstance() {
        if (sInstance == null) {
            new RuntimeException("FrameApplication == null ?? you should extends FrameApplication in you app");
        }
        return sInstance;
    }

}
