/**
 * 文件名：RemindBySelfDetailActivity.java 2015-7-7 下午10:06:28
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.activity;

import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.interfaces.IActivity;
import cn.bubbycare.ibreast.utils.ActivityUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Description : 自检的图文显示Activity Create time : 2015-7-7 下午10:06:28 Project name:
 * ibreast File name : RemindBySelfDetailActivity.java Encoded : UTF-8
 * 
 * @author 许仕永
 * @JKD JDK 1.6.0_21
 * @version v1.0.0
 */
public class RemindBySelfDetailActivity extends Activity implements IActivity
{
	ImageView ivBack;
	ImageButton btnRight;
	TextView txtTitle;

	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ramindbyself_detail);
		initView();
		initValue();
		initEvent();
	}

	public void initView()
	{
		ivBack = (ImageView) this.findViewById(R.id.include_appoinment_iv_back);
		btnRight = (ImageButton) this.findViewById(R.id.include_right_button);
		btnRight.setVisibility(View.VISIBLE);
		txtTitle = (TextView)this.findViewById(R.id.include_appoinment_tv_title);
	}


	public void initValue()
	{
		// TODO Auto-generated method stub
		txtTitle.setText(R.string.string_selfremind);
	}


	public void initEvent()
	{
		// TODO Auto-generated method stub
		ivBack.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				finish();
			}
		});
		btnRight.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				ActivityUtil.goToNewActivity(RemindBySelfDetailActivity.this, ChestActivity.class);
			}
		});
	}
}
