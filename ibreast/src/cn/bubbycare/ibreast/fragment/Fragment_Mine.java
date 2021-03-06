package cn.bubbycare.ibreast.fragment;

import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.activity.AppoinActivity;
import cn.bubbycare.ibreast.activity.CaseActivity;
import cn.bubbycare.ibreast.utils.ActivityUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Fragment_Mine extends Fragment
{
	private View view;

	private RelativeLayout rela_appoinment;

	private RelativeLayout rela_manager;


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		view = inflater.inflate(R.layout.mine, null);
		return view;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		rela_appoinment = (RelativeLayout) view.findViewById(R.id.rela_appointment);
		rela_manager = (RelativeLayout) view.findViewById(R.id.rela_manager);

		rela_appoinment.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// add by xushiyong 20150708 for go to new Activity
				ActivityUtil.goToNewActivity(getActivity(), AppoinActivity.class);
			}
		});
		rela_manager.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// add by xushiyong 20150708 for go to new Activity
				ActivityUtil.goToNewActivity(getActivity(), CaseActivity.class);
			}
		});
	}
}
