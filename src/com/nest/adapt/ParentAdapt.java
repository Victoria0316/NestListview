package com.nest.adapt;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.nest.activity.R;
import com.nest.base.BaseObjectListAdapter;
import com.nest.entity.Entity;
import com.nest.entity.ShowEntity;

/**
 * 父listview适配器
 * @author mmsx
 *
 */
public class ParentAdapt extends BaseObjectListAdapter{
	
	private ArrayList<ShowEntity> mChildList;
	public static int mParentItem = -1;
	public static boolean mbShowChild = false;
	
	public ParentAdapt(Context context, List<? extends Entity> datas) {
		super(context, datas);
		initData();
	}
	
	private void initData() {
		mChildList = new ArrayList<ShowEntity>();
		mChildList.clear();
		for (int i = 0; i < 5; i++) {
			ShowEntity tempEntity = new ShowEntity("字标题" + String.valueOf(i), "内容");
			mChildList.add(tempEntity);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vHolder = null;
		if (convertView == null) {
			vHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.activity_main_list_item, null);
			vHolder.textViewTitle = (TextView)convertView.findViewById(R.id.textView_1);
			vHolder.textViewContent= (TextView)convertView.findViewById(R.id.textView_2);
			vHolder.listViewItem = (ListView)convertView.findViewById(R.id.listView_child);
			vHolder.buttonStake = (Button)convertView.findViewById(R.id.button_1);
			convertView.setTag(vHolder);
		}else {
			vHolder = (ViewHolder) convertView.getTag();
		}
		
		ShowEntity tempEntity = (ShowEntity) mDatas.get(position);
		vHolder.textViewTitle.setText(tempEntity.getTitle());
		vHolder.textViewContent.setText(tempEntity.getContent());
		
		//点击那个弹出那个，如果已经弹出就收回子listview
		if (mParentItem == position && mbShowChild) {
			//子listview实在这里加载数据的
			ChildAdapt tempAdapt = new ChildAdapt(mContext, mChildList);
			vHolder.listViewItem.setAdapter(tempAdapt);
			vHolder.listViewItem.setVisibility(View.VISIBLE);
			
			//子listview的点击监听
			vHolder.listViewItem.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Toast.makeText(mContext, "Child Listview" + String.valueOf(position), Toast.LENGTH_SHORT).show();
					
				}
			});
		}else {
			vHolder.listViewItem.setVisibility(View.GONE);
		}
		
		vHolder.buttonStake.setOnClickListener(new ParentButtonLisener());
		//记住是那个button事件
		vHolder.buttonStake.setTag(position);
	    
		return convertView;
	}
	
	class ViewHolder{
		TextView textViewTitle;
		TextView textViewContent;
		ListView listViewItem;
		Button buttonStake;
	}
	
	//父listview的button的监听
	private class ParentButtonLisener implements OnClickListener{
		@Override
		public void onClick(View v) {
			Integer nPosition = (Integer) (v.getTag());
			Toast.makeText(mContext, "提示" + String.valueOf(nPosition.intValue()), Toast.LENGTH_SHORT).show();
		}
	}
}
