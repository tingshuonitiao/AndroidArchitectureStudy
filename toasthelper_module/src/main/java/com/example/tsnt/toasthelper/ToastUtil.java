package com.example.tsnt.toasthelper;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by zhangxiaozong on 18/1/13.
 */

public class ToastUtil {
    private static long firstTime;
    private static long secondTime;

    private static String oldMsg;

    private static Context mApplicationContext;

    private static Toast mToast;

    public static void init(Context applicationContext) {
        mApplicationContext = applicationContext;
    }

    public static void showToast(String message) {
        message += "  -- by module";
        if (mToast == null) {
            mToast = Toast.makeText(mApplicationContext, message, Toast.LENGTH_SHORT);
            firstTime = System.currentTimeMillis();
            mToast.show();
        } else {
            secondTime = System.currentTimeMillis();
            if (message.equals(oldMsg)) {
                if (secondTime - firstTime > Toast.LENGTH_SHORT) {
                    mToast.show();
                }
            } else {
                oldMsg = message;
                mToast.setText(message);
                mToast.show();
            }
            firstTime = secondTime;
        }
    }
}
