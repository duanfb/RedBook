package com.redbook.neo.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.redbook.neo.R;
import com.redbook.neo.ui.activity.AutoViewPagerActivity;
import com.redbook.neo.ui.activity.MainActivity;

/**
 * @author : neo.duan
 * @date : 	 2016/6/25 0025
 * @desc : 用于通过intent进行页面间的跳转(单例模式)
 */
public class IntentManager {
    private final String TAG = "IntentManager";

    private IntentManager() {
    }

    private static class IntentManagerHolder {
        private static final IntentManager instance = new IntentManager();
    }

    public static final IntentManager getInstance() {
        return IntentManagerHolder.instance;
    }

    /**
     * 公共启动Activity方法
     * @param context
     * @param intent
     */
    private void startActivity(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.anim_push_left_in,
                    R.anim.anim_push_left_out);
        }
    }

    private void startAcitivityForResult(Activity context, Intent intent,
                                         int requestCode) {
        if (context == null) {
            return;
        }
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * 跳转到首页Activity
     *
     * @param context
     */
    public void goMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(context, intent);
//        startActivity(context, new Intent(context, TestActivity.class));
    }

    /**
     * 跳转到自动滚动ViewPagerActivity
     *
     * @param context
     */
    public void goAutoViewPagerActivity(Context context) {
        Intent intent = new Intent(context, AutoViewPagerActivity.class);
        startActivity(context, intent);
    }
}
