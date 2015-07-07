package cn.bubbycare.ibreast.fragment;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.activity.Basics;
import cn.bubbycare.ibreast.activity.DataSettingActivity;
import cn.bubbycare.ibreast.activity.RemindBySelfDetailActivity;
import cn.bubbycare.ibreast.utils.ActivityUtil;

@SuppressLint("ResourceAsColor")
public class FragmentAppIndex extends Fragment implements OnClickListener{

	/*
	 * 3个按钮
	 * */
	Button but1;
	Button but2;
	Button but3;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_1, null);
		but1 = (Button)view.findViewById(R.id.fragment1_bt_hffxyc);
		but2 = (Button)view.findViewById(R.id.fragment1_bt_mmzj);
		but3 = (Button)view.findViewById(R.id.fragment1_bt_zyjc);
		but1.setOnClickListener(this);
		but2.setOnClickListener(this);
		but3.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		textcolor();
		Intent it =new Intent();
		switch(v.getId()){
		case R.id.fragment1_bt_hffxyc:
			but1.setTextColor(R.color.white);
			it.setClass(getActivity(), Basics.class);
			startActivity(it);
			break;
		case R.id.fragment1_bt_mmzj:
			but2.setTextColor(R.color.white);
			ActivityUtil.goToNewActivity(getActivity(), RemindBySelfDetailActivity.class);
			break;
		case R.id.fragment1_bt_zyjc:
			but3.setTextColor(R.color.white);
			break;
		}
	}
	void textcolor(){
		but1.setTextColor(R.color.black);
		but2.setTextColor(R.color.black);
		but3.setTextColor(R.color.black);
	}
}
