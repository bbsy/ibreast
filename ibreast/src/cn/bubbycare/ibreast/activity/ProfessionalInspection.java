package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Inspection_adapter;
import cn.bubbycare.ibreast.bean.ResultBean;

/**
 * 专业检查
 * */
public class ProfessionalInspection extends Activity {
	private ListView lv_result;

	private Inspection_adapter adapter;

	private View view;
	private TextView tv_title;
	private ImageView btn_add_data;
	private ImageView btn_back;
	private Button btnBeginCheck;
	private List<ResultBean> list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_professional_inspection);
		initView();
	}

	private void initView() 
	{
		tv_title = (TextView)findViewById(R.id.inspection_tv_title);
		
		btn_add_data = (ImageView)findViewById(R.id.insperction_add_history_records);
		
		btn_back = (ImageView)findViewById(R.id.inspection_iv_back);
		
		lv_result = (ListView) findViewById(R.id.inspection_lv);
		btnBeginCheck = (Button)findViewById(R.id.professional_inspection_btn_com);
		btnBeginCheck.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				Intent intent = new Intent(ProfessionalInspection.this,AppoinActivity.class);
				startActivity(intent);
			}
		});
		
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		// 虚拟数据
		list = new ArrayList<ResultBean>();
		
		for (int i = 0; i < 4; i++) {
			ResultBean bean = new ResultBean();
			bean.setData("2015/6/30");
			bean.setCategory("医生/X射线/B超");
			bean.setResult("检查结果");
			list.add(bean);
		}
		adapter = new Inspection_adapter(ProfessionalInspection.this, list);
		lv_result.setDividerHeight(0);
		lv_result.setAdapter(adapter);

	}
}
