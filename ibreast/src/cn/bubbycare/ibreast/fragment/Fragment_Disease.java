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
import cn.bubbycare.ibreast.adapter.DiseaseAdapter;
import cn.bubbycare.ibreast.bean.DiseaseBean;

/**
 * 疾病知识
 * */
public class Fragment_Disease extends Fragment {

	private View view;

	private ListView lv;

	private DiseaseAdapter adapter;

	private List<DiseaseBean> list;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.disease_knowledge, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		lv = (ListView) view.findViewById(R.id.lv_disease_knowledge);
		list = new ArrayList<DiseaseBean>();
		for (int i = 0; i < 3; i++) {
			DiseaseBean bean = new DiseaseBean();
			bean.setIntroduce("乳房结构知识介绍");
			bean.setTime("2015/7/2");
			list.add(bean);
		}
		adapter = new DiseaseAdapter(view.getContext().getApplicationContext(),
				list);
		lv.setAdapter(adapter);
	}
}
