package com.redbook.neo.ui.adapter.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * ViewPager adapter的基类
 * @param <T>
 */
public abstract class BasePagerAdapter<T> extends PagerAdapter {
	protected List<T> mInfos;
	private SparseArray<View> mViewArray;
	protected Context mContext;

	public BasePagerAdapter(Context context, List<T> infos) {
		this.mContext = context;
		this.mInfos = infos;
		this.mViewArray = new SparseArray<View>(infos.size());
	}

	@Override
	public int getCount() {
		return mInfos != null ? mInfos.size() : 0;
	}

	public T getItem(int position) {
		return mInfos != null ? mInfos.get(position) : null;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = mViewArray.get(position);
		if (view == null) {
			view = getView(container, position);
			mViewArray.put(position, view);
		}
		container.addView(view);
		return view;
	}

	public abstract View getView(ViewGroup container, int position);

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViewArray.get(position));
	}
}
