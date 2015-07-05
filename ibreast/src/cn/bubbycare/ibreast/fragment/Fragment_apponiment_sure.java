package cn.bubbycare.ibreast.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.bubbycare.ibreast.R;

/**
 * 我要预约二级页面
 * */
public class Fragment_apponiment_sure extends Fragment
{
	
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater
				.inflate(R.layout.make_appoinment_sure, null);
		return view;
	}
}
