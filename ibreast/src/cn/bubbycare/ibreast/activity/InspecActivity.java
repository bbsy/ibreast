package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Inspection_adapter;
import cn.bubbycare.ibreast.bean.ResultBean;

/**
 * 咪咪自检
 * */
public class InspecActivity extends Activity {
	private ListView lv_result;

	private Inspection_adapter adapter;

	private ImageView iv_back;

	private View view;

	private Button btn_inspect;
	// 设置检查日期
	private Button btn_setCheckData;

	private List<ResultBean> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_checked_self);
		initView();
	}

	private void initView() {
		
		btn_setCheckData = (Button) findViewById(R.id.inspection_btn_set_data);
		btn_setCheckData.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(InspecActivity.this,
						DataSettingActivity.class);
				startActivity(intent);
			}
		});
		iv_back = (ImageView) findViewById(R.id.check_self_iv_back);
		iv_back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

		btn_inspect = (Button) findViewById(R.id.inspection_btn_com);
		btn_inspect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(InspecActivity.this,
						RemindBySelfDetailActivity.class);
				startActivity(intent);
			}
		});
		lv_result = (ListView) findViewById(R.id.professional_inspection_lv);
		// 虚拟数据
		list = new ArrayList<ResultBean>();
		for (int i = 0; i < 5; i++) {
			ResultBean bean = new ResultBean();
			bean.setData("2015/6/30");
			bean.setCategory("医生/X射线/B超");
			bean.setResult("检查结果");
			list.add(bean);
		}
		adapter = new Inspection_adapter(InspecActivity.this, list);
		lv_result.setDividerHeight(0);
		lv_result.setAdapter(adapter);

	}

}
