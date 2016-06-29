package com.redbook.neo.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.redbook.neo.ui.adapter.base.BasePagerAdapter;

import java.util.List;

/**
 * banner条的adapter
 */
public class BannerAdapter extends BasePagerAdapter<Integer> {

	public BannerAdapter(Context context, List<Integer> infos) {
		super(context, infos);
	}

	@Override
	public View getView(ViewGroup container, int position) {
		ImageView imageView = new ImageView(mContext);
		imageView.setImageResource(mInfos.get(position));
		return imageView;
	}
}
