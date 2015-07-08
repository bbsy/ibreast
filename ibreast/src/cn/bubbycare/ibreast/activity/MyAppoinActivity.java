package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Mine_manager_adapter;
import cn.bubbycare.ibreast.bean.HospitalBean;

/**
 * 我的预约
 * */
public class MyAppoinActivity extends Activity {

	private ListView lv;

	private Mine_manager_adapter adapter;

	private List<HospitalBean> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mine_oppination);
		initView();
	}

	private void initView() 
	{
		lv = (ListView) findViewById(R.id.mine_oppination_lv);
		list = new ArrayList<HospitalBean>();
		for (int i = 0; i < 3; i++) {
			HospitalBean bean = new HospitalBean();
			bean.setHospitalAdress("福建省福州市");
			bean.setHospitalName("福建省二人民医院");
			list.add(bean);
		}
		adapter = new Mine_manager_adapter(MyAppoinActivity.this, list);
		lv.setAdapter(adapter);
	}
}
