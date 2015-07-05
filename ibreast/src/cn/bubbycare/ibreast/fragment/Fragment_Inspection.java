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
import cn.bubbycare.ibreast.adapter.Inspection_adapter;
import cn.bubbycare.ibreast.bean.ResultBean;

/**
 * 专业检查适配器
 * */
public class Fragment_Inspection extends Fragment {
	private ListView lv_result;

	private Inspection_adapter adapter;

	private View view;

	private List<ResultBean> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater
				.inflate(R.layout.fragment_professional_inspection, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		lv_result = (ListView) view.findViewById(R.id.inspection_lv);
		// 虚拟数据
		list = new ArrayList<ResultBean>();
		for (int i = 0; i < 2; i++) {
			ResultBean bean = new ResultBean();
			bean.setData("2015/6/30");
			bean.setCategory("医生/X射线/B超");
			bean.setResult("检查结果");
			list.add(bean);
		}
		adapter = new Inspection_adapter(this.getActivity()
				.getApplicationContext(), list);
		lv_result.setDividerHeight(0);
		lv_result.setAdapter(adapter);

	}
}
