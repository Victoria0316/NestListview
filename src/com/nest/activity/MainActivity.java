package com.nest.activity;

import java.util.ArrayList;

import com.nest.adapt.ParentAdapt;
import com.nest.entity.ShowEntity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.app.Activity;
/**
 * listviewǶ��listviewʵ��Ч��
 * @author mmsx
 *
 */
public class MainActivity extends Activity {
	
	private ParentAdapt mParentAdapt;
	private ArrayList<ShowEntity> mParentList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		initView();
	}

	private void initData() {
		mParentList = new ArrayList<ShowEntity>();
		mParentList.clear();
		for (int i = 0; i < 20; i++) {
			ShowEntity tempEntity = new ShowEntity("����" + String.valueOf(i), "����");
			mParentList.add(tempEntity);
		}
	}

	private void initView() {
		ListView listView = (ListView)findViewById(R.id.listView1);
		mParentAdapt = new ParentAdapt(this, mParentList);
		listView.setAdapter(mParentAdapt);
		listView.setOnItemClickListener(new AdaptItemClick());
		
		//����listview�Ͳ�дʾ����
//		listView.setOnItemLongClickListener(listener);
	}
	
	//��listview�ĵ����¼��ļ���
	private class AdaptItemClick implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (ParentAdapt.mParentItem == position && ParentAdapt.mbShowChild) {
				ParentAdapt.mbShowChild = false;
			}else {
				ParentAdapt.mbShowChild = true;
			}
			ParentAdapt.mParentItem = position;
			mParentAdapt.notifyDataSetChanged();
		}
	}

}
