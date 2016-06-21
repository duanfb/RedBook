package com.redbook.neo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

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
    }
}
