package com.redbook.neo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.redbook.neo.R;
import com.redbook.neo.ui.adapter.BannerAdapter;
import com.redbook.neo.ui.widget.autoviewpager.AutoViewPager;
import com.redbook.neo.ui.widget.autoviewpager.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class AutoViewPagerActivity extends AppCompatActivity {
    private AutoViewPager mViewPager;
    private CirclePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_viewpager);
        mViewPager = (AutoViewPager) findViewById(R.id.view_pager);
        List<Integer> imageIdList = new ArrayList<>();
        imageIdList.add(R.drawable.banner);
        imageIdList.add(R.drawable.banner);
        imageIdList.add(R.drawable.banner);
        imageIdList.add(R.drawable.banner);
        mViewPager.setAdapter(new BannerAdapter(this, imageIdList));
        mViewPager.setSwipeScrollDurationFactor(10);
        mViewPager.setAutoScrollDurationFactor(10);
        mViewPager.startScroll();

        mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mViewPager);
        //mIndicator.setOrientation(VERTICAL);
    }
}
