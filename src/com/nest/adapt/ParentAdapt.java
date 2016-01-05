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
 * ��listview������
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
			ShowEntity tempEntity = new ShowEntity("�ֱ���" + String.valueOf(i), "����");
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
		
		//����Ǹ������Ǹ�������Ѿ��������ջ���listview
		if (mParentItem == position && mbShowChild) {
			//��listviewʵ������������ݵ�
			ChildAdapt tempAdapt = new ChildAdapt(mContext, mChildList);
			vHolder.listViewItem.setAdapter(tempAdapt);
			vHolder.listViewItem.setVisibility(View.VISIBLE);
			
			//��listview�ĵ������
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
		//��ס���Ǹ�button�¼�
		vHolder.buttonStake.setTag(position);
	    
		return convertView;
	}
	
	class ViewHolder{
		TextView textViewTitle;
		TextView textViewContent;
		ListView listViewItem;
		Button buttonStake;
	}
	
	//��listview��button�ļ���
	private class ParentButtonLisener implements OnClickListener{
		@Override
		public void onClick(View v) {
			Integer nPosition = (Integer) (v.getTag());
			Toast.makeText(mContext, "��ʾ" + String.valueOf(nPosition.intValue()), Toast.LENGTH_SHORT).show();
		}
	}
}
