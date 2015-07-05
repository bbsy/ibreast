package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Mine_manager_adapter;
import cn.bubbycare.ibreast.bean.HospitalBean;

/**
 * 我的预约
 * */
public class Mine_Appoinment extends Fragment{
	
	private View view;
	
	private ListView lv;
	
	private Mine_manager_adapter adapter;

	private List<HospitalBean> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater
				.inflate(R.layout.mine_oppination, null);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		lv = (ListView)view.findViewById(R.id.mine_oppination_lv);
		list = new ArrayList<HospitalBean>();
		for (int i = 0; i < 3; i++) {
			HospitalBean bean = new HospitalBean();
			bean.setHospitalAdress("福建省福州市");
			bean.setHospitalName("福建省二人民医院");
			list.add(bean);
		}
		adapter = new Mine_manager_adapter(view.getContext().getApplicationContext(), list);
		lv.setAdapter(adapter);
	}
}
