package cn.bubbycare.ibreast.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.adapter.Disease_manager_adapter;
import cn.bubbycare.ibreast.bean.DiseaseBean;

public class CaseActivity extends Activity {

	private ListView listView;

	private List<DiseaseBean> list;

	private Disease_manager_adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mine_manager);
		initView();
	}

	private void initView() {
		listView = (ListView) findViewById(R.id.mine_manager_lv);
		/**
		 * 虚拟数据
		 * */
		list = new ArrayList<DiseaseBean>();
		for (int i = 0; i < 3; i++) {
			DiseaseBean bean = new DiseaseBean();
			bean.setAdvice("建议");
			bean.setResult("去医院进一步检查");
			list.add(bean);
		}
		adapter = new Disease_manager_adapter(CaseActivity.this, list);
		listView.setAdapter(adapter);
	}
}
