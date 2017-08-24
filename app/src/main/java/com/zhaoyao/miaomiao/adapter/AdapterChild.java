
package com.zhaoyao.miaomiao.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class AdapterChild<T> extends ZhaoYaoAdapter<T>{

	public AdapterChild(Context context, List<T> mDatas, int itemLayoutId) {
		super(context, mDatas, itemLayoutId);
	}

	@Override
	public int getCount()
	{
		return mDatas==null?0:mDatas.size();
	}

	@Override
	public T getItem(int position)
	{
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		final ViewHolder viewHolder = getViewHolder(position, convertView,
				parent);
		convert(viewHolder, getItem(position),position);
		return viewHolder.getConvertView();

	}

	public abstract void convert(ViewHolder helper, T item,int position);

	private ViewHolder getViewHolder(int position, View convertView,
			ViewGroup parent)
	{
		return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
				position);
	}
	
}
