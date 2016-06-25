package com.redbook.neo.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @author : neo.duan
 * @date : 	 2016/6/25 0025
 * @desc : 封装系统的RecyclerView，方便日后需求变动的维护
 */
public class XRecyclerView extends RecyclerView {

    private Context mContext;

    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    /**
     * 初始化设置默认的一些属性
     */
    private void init() {
        // 设置水平布局
        this.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false));
        // 设置item动画
        this.setItemAnimator(new DefaultItemAnimator());
        //设置水平分割线
        this.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
    }
}
