package cn.bubbycare.ibreast.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cn.bubbycare.ibreast.R;

public class MineActivity extends Fragment {

	private RelativeLayout rela_appoinment;

	private RelativeLayout rela_manager;
	
	private RelativeLayout rela_about_us;

	private View view;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.mine, null);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		rela_appoinment = (RelativeLayout) view
				.findViewById(R.id.rela_appointment);
		rela_manager = (RelativeLayout) view.findViewById(R.id.rela_manager);
		
		rela_about_us = (RelativeLayout)view.findViewById(R.id.rela_about_us);
		// 我的预约
		rela_appoinment.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(view.getContext()
						.getApplicationContext(), MyAppoinActivity.class);
				startActivity(intent);
			}
		});
		rela_manager.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(view.getContext()
						.getApplicationContext(), CaseActivity.class);
				startActivity(intent);
			}
		});
		rela_about_us.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(view.getContext()
						.getApplicationContext(), InspecActivity.class);
				startActivity(intent);
			}
		});

	}
}
