package com.nest.adapt;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nest.activity.R;
import com.nest.base.BaseObjectListAdapter;
import com.nest.entity.Entity;
import com.nest.entity.ShowEntity;
/**
 * ◊”listview  ≈‰∆˜
 * @author mmsx
 *
 */
public class ChildAdapt extends BaseObjectListAdapter{

	public ChildAdapt(Context context, List<? extends Entity> datas) {
		super(context, datas);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vHolder = null;
		if (convertView == null) {
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.activity_main_list_item_1, null);
			vHolder.textViewTitle = (TextView)convertView.findViewById(R.id.textView_1);
			vHolder.textViewContent= (TextView)convertView.findViewById(R.id.textView_2);
			convertView.setTag(vHolder);
		}else {
			vHolder = (ViewHolder) convertView.getTag();
		}
		ShowEntity tempEntity = (ShowEntity) mDatas.get(position);
		vHolder.textViewTitle.setText(tempEntity.getTitle());
		vHolder.textViewContent.setText(tempEntity.getContent());
		return convertView;
	}
	
	class ViewHolder{
		TextView textViewTitle;
		TextView textViewContent;
	}
}
