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
import cn.bubbycare.ibreast.adapter.Disease_manager_adapter;
import cn.bubbycare.ibreast.bean.DiseaseBean;

public class Fragment_disease_manager extends Fragment{
	
	private View view ;
	
	private ListView listView;
	
	private List<DiseaseBean> list;
	
	private Disease_manager_adapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.mine_manager,null);
		
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listView = (ListView)view.findViewById(R.id.mine_manager_lv);
		/**
		 * 虚拟数据
		 * */
		list = new ArrayList<DiseaseBean>();
		for (int i = 0; i < 3; i++) 
		{
			DiseaseBean bean = new DiseaseBean();
			bean.setAdvice("建议");
			bean.setResult("去医院进一步检查");
			list.add(bean);
		}
		adapter = new Disease_manager_adapter(view.getContext().getApplicationContext(), list);
		listView.setAdapter(adapter);
	}
}
