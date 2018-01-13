package com.example.tsnt.androidarchitecturestudy;

import android.app.Application;

import com.example.tsnt.toasthelper.ToastUtil;

/**
 * Created by zhangxiaozong on 18/1/13.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.init(getApplicationContext());
    }
}
