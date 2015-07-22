package cn.bubbycare.ibreast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import cn.bubbycare.ibreast.R;

/**
 * 我要预约二级页面
 * */
public class Appoin2Activity extends Activity {

	private ImageView iv_back;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.make_appoinment_sure);
		initView();
	}
	private void initView() {
		iv_back = (ImageView)findViewById(R.id.appoinment_iv_back);
		iv_back.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				finish();
			}
		});
	}
}