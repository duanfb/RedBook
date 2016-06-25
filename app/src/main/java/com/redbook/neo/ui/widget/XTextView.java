package com.redbook.neo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author : neo.duan
 * @date : 	 2016/6/25 0025
 * @desc : 请描述该文件
 */
public class XTextView extends TextView {
    public XTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public XTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XTextView(Context context) {
        this(context, null);
    }

    private void init() {

    }
}
