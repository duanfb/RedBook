package com.redbook.neo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.redbook.neo.R;
import com.redbook.neo.ui.adapter.MainAdapter;
import com.redbook.neo.ui.widget.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
