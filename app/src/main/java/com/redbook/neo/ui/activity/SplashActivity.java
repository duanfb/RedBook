package com.redbook.neo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.redbook.neo.manager.IntentManager;

/**
 * @author : neo.duan
 * @date : 	 2016/6/21 0021
 * @desc : Splash页面
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new View(this));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                IntentManager.getInstance().goAutoViewPagerActivity(SplashActivity.this);
                finish();
            }
        },2000);
    }
}
