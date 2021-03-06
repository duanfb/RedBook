package com.redbook.neo.ui.widget.refreshlayout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.redbook.neo.R;

/**
 * @author : neo.duan
 * @date : 	 2016/6/25 0025
 * @desc : 默认下拉header
 */
public class DefaultHeader extends BaseHeader {

    private Context mContext;

    private int rotationSrc;
    private int arrowSrc;

    private long freshTime;

    private TextView headerTitle;
    private TextView headerTime;
    private ImageView headerArrow;
    private ProgressBar headerProgressbar;

    private final int ROTATE_ANIM_DURATION = 180;
    private RotateAnimation mRotateUpAnim;
    private RotateAnimation mRotateDownAnim;

    public DefaultHeader(Context context){
        this(context, R.drawable.progress_small,R.drawable.arrow);
    }

    public DefaultHeader(Context context,int rotationSrc,int arrowSrc){
        this.mContext = context;
        this.rotationSrc = rotationSrc;
        this.arrowSrc = arrowSrc;

        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);
        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.default_header, viewGroup, true);
        headerTitle = (TextView) view.findViewById(R.id.default_header_title);
        headerTime = (TextView) view.findViewById(R.id.default_header_time);
        headerArrow = (ImageView) view.findViewById(R.id.default_header_arrow);
        headerProgressbar = (ProgressBar) view.findViewById(R.id.default_header_progressbar);
        headerProgressbar.setIndeterminateDrawable(ContextCompat.getDrawable(mContext, rotationSrc));
        headerArrow.setImageResource(arrowSrc);
        return view;
    }

    /**
     * 拖动前，设置刷新时间等
     *
     * @param rootView
     */
    @Override
    public void onPreDrag(View rootView) {
        if (freshTime == 0) {
            freshTime = System.currentTimeMillis();
        } else {
            int m = (int) ((System.currentTimeMillis() - freshTime) / 1000 / 60);
            if (m >= 1 && m < 60) {
                headerTime.setText(m + "分钟前");
            } else if (m >= 60) {
                int h = m / 60;
                headerTime.setText(h + "小时前");
            } else if (m > 60 * 24) {
                int d = m / (60 * 24);
                headerTime.setText(d + "天前");
            } else if (m == 0) {
                headerTime.setText("刚刚");
            }
        }
    }

    @Override
    public void onDropAnim(View rootView, int dy) {

    }

    /**
     * 手指拖动控件过程中每次抵达临界点时的回调，用户可以根据手指方向设置临界动画
     *
     * @param upOrDown 是上拉还是下拉
     */
    @Override
    public void onLimitDes(View rootView, boolean upOrDown) {
        if (!upOrDown){
            headerTitle.setText("松开刷新数据");
            if (headerArrow.getVisibility()==View.VISIBLE)
                headerArrow.startAnimation(mRotateUpAnim);
        }
        else {
            headerTitle.setText("下拉刷新");
            if (headerArrow.getVisibility()==View.VISIBLE)
                headerArrow.startAnimation(mRotateDownAnim);
        }
    }


    @Override
    public void onStartAnim() {
        freshTime = System.currentTimeMillis();
        headerTitle.setText("正在刷新");
        headerArrow.setVisibility(View.INVISIBLE);
        headerArrow.clearAnimation();
        headerProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishAnim() {
        headerArrow.setVisibility(View.VISIBLE);
        headerProgressbar.setVisibility(View.INVISIBLE);
    }
}
