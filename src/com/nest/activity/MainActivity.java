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
 * listview嵌套listview实现效果
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
			ShowEntity tempEntity = new ShowEntity("标题" + String.valueOf(i), "内容");
			mParentList.add(tempEntity);
		}
	}

	private void initView() {
		ListView listView = (ListView)findViewById(R.id.listView1);
		mParentAdapt = new ParentAdapt(this, mParentList);
		listView.setAdapter(mParentAdapt);
		listView.setOnItemClickListener(new AdaptItemClick());
		
		//长按listview就不写示范了
//		listView.setOnItemLongClickListener(listener);
	}
	
	//父listview的单击事件的监听
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
