package com.redbook.neo.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.redbook.neo.R;
import com.redbook.neo.ui.adapter.MainAdapter;
import com.redbook.neo.ui.widget.XRecyclerView;
import com.redbook.neo.ui.widget.refreshlayout.DefaultHeader;
import com.redbook.neo.ui.widget.refreshlayout.XRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private XRecyclerView mRecyclerView;
    private XRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRefreshLayout = (XRefreshLayout) findViewById(R.id.refresh);
        //设置下拉模式为跟随
        mRefreshLayout.setType(XRefreshLayout.Type.FOLLOW);
        //设置下拉监听
        mRefreshLayout.setListener(new XRefreshLayout.OnFreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                Log.d(TAG,"下拉刷新 ");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.onFinishFreshAndLoad();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                //上拉加载更多
                Log.d(TAG,"上拉加载更多 ");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.onFinishFreshAndLoad();
                    }
                }, 1000);
            }
        });

        //设置默认刷新头部
        mRefreshLayout.setHeader(new DefaultHeader(this));
//        mRefreshLayout.setFooter(new AliFooter(this,false));

        mRecyclerView = (XRecyclerView) findViewById(R.id.rcv_main);
        mRecyclerView.setAdapter(new MainAdapter(this,mock()));
    }

    private List<String> mock() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("NEO  " + i);
        }
        return list;
    }
}
