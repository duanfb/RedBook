package com.redbook.neo.ui.adapter;

import android.content.Context;

import com.redbook.neo.R;
import com.redbook.neo.ui.adapter.base.CommonAdapter;
import com.redbook.neo.ui.adapter.base.ViewHolder;

import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/6/25 0025
 * @desc : 请描述该文件
 */
public class MainAdapter extends CommonAdapter<String>{

    public MainAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public void convert(ViewHolder holder, String text) {
        holder.setText(R.id.tv_name,text);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_main;
    }
}
