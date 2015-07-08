package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.OneselfAdapter;
import cn.bubbycare.ibreast.utils.Patient;

public class TumorActivity extends Activity implements OnClickListener {

	Button bt; // 添加，提交按钮
	TextView submit;
	ImageView iv; // 返回按钮
	ListView listView1; // 我的患病历史
	ListView listView2; // 母亲的患病历史
	ArrayList<Patient> list = new ArrayList<Patient>();
	OneselfAdapter adapter;
	static int i = 1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tumor);
		init();
	}

	void init() {
		bt = (Button) this.findViewById(R.id.Tumor_add);
		submit = (TextView) this.findViewById(R.id.submit);
		iv = (ImageView) this.findViewById(R.id.Tumor_backtrack);
		listView1 = (ListView) this.findViewById(R.id.Tumor_list1);
		listView2 = (ListView) this.findViewById(R.id.Tumor_list2);
		list.add(new Patient("第一次患病", "年龄"));
		list.add(new Patient("第一次患病", "年龄"));
		adapter = new OneselfAdapter(this, list);
		listView1.setAdapter(adapter);
		bt.setOnClickListener(this);
		submit.setOnClickListener(this);
		iv.setOnClickListener(this);
	}

	// 按钮的点击事件
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.Tumor_backtrack:
			finish();
			break;
		case R.id.Tumor_add:
			list.add(new Patient("第"+i+"次患病", "年龄"));
			i++;
			adapter.notifyDataSetChanged();
			
			break;
		case R.id.submit:
			Intent it = new Intent(this, HFFYCActivity.class);
			startActivity(it);
			Toast.makeText(this, "等等、", 3).show();
			break;
		default:
			break;
		}
	}
}
