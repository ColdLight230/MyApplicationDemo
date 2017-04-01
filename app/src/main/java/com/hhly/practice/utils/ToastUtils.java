package com.hhly.practice.utils;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * toast 方法集合
 */
public class ToastUtils {

    private Context context;
    public static long lastTime;

    @Inject
    public ToastUtils(Context context) {
        this.context = context;
    }

    public void makeText(String msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    public void makeText(int resId, int duration) {
        makeText(context.getResources().getString(resId), duration);
    }

    public void makeText(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void makeText(int resId) {
        Toast.makeText(context, context.getResources().getString(resId), Toast.LENGTH_SHORT).show();
    }
    /**
     * 500毫秒禁止点击
     *
     * @return
     */
    public static boolean isClickable() {
        boolean flag = false;
        long time = System.currentTimeMillis() - lastTime;

        if (time > 500) {
            flag = true;
        }
        lastTime = System.currentTimeMillis();
        return flag;
    }
}
