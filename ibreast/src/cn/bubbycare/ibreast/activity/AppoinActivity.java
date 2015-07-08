package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Appoinment_adapter;
import cn.bubbycare.ibreast.bean.HospitalBean;
import cn.bubbycare.ibreast.utils.ActivityUtil;

public class AppoinActivity extends Activity// implements OnItemClickListener
{
	private ListView lv_appoinment;

	private Appoinment_adapter adapter;

	private HospitalBean bean;

	private List<HospitalBean> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fragment_appointment);
		initView();
	}

	private void initView() {
		lv_appoinment = (ListView)findViewById(R.id.appoinment_lv);

		list = new ArrayList<HospitalBean>();
		for (int i = 0; i < 3; i++) {
			bean = new HospitalBean();
			bean.setHospitalName("医院名称");
			bean.setHospitalAdress("长宁区某地址");
			list.add(bean);
		}
		adapter = new Appoinment_adapter(AppoinActivity.this, list);
		lv_appoinment.setAdapter(adapter);
	}

//	@Override
//	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
//	{
//		// TODO Auto-generated method stub
//		
//		
//	}
	
	
}
