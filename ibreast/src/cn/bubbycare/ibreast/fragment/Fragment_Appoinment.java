package cn.bubbycare.ibreast.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Appoinment_adapter;
import cn.bubbycare.ibreast.bean.HospitalBean;

/**
 * 我要预约
 * */
public class Fragment_Appoinment extends Fragment {
	private View view;

	private ListView lv_appoinment;

	private Appoinment_adapter adapter;

	private HospitalBean bean;

	private List<HospitalBean> list;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_appointment, null);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		lv_appoinment = (ListView) view.findViewById(R.id.appoinment_lv);
		list = new ArrayList<HospitalBean>();
		// 虚拟数据
		for (int i = 0; i < 3; i++) {
			bean = new HospitalBean();
			bean.setHospitalName("医院名称");
			bean.setHospitalAdress("长宁区某地址");
			list.add(bean);
		}
		adapter = new Appoinment_adapter(view.getContext()
				.getApplicationContext(), list);
		lv_appoinment.setAdapter(adapter);
	}
}
