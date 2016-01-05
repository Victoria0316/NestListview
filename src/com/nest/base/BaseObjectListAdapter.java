package com.nest.base;

import java.util.ArrayList;
import java.util.List;

import com.nest.entity.Entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class BaseObjectListAdapter extends BaseAdapter {

	protected Context mContext;
	protected LayoutInflater mInflater;
	protected List<? extends Entity> mDatas = new ArrayList<Entity>();

	public BaseObjectListAdapter(Context context, List<? extends Entity> datas) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
		if (datas != null) {
			mDatas = datas;
		}
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

	public List<? extends Entity> getDatas() {
		return mDatas;
	}

}
