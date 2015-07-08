package cn.bubbycare.ibreast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import cn.bubbycare.ibreast.R;

/**
 * 我要预约二级页面
 * */
public class Appoin2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.make_appoinment_sure);
	}
}