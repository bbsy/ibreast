package cn.bubbycare.ibreast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.interfaces.IActivity;

/**
 * Description : 自检的提醒日期设置
 * Create time : 2015-7-7 下午10:40:39
 * Project name: ibreast
 * File name   : DataSettingActivity.java
 * Encoded     : UTF-8
 * @author     许仕永
 * @JKD        JDK 1.6.0_21 
 * @version    v1.0.0
 */
public class DataSettingActivity extends Activity implements IActivity{

    private LinearLayout itemNormalLastStartTime;
    private LinearLayout itemNormalLastEndTime;
    private LinearLayout itemNormalRemindTime;
    private LinearLayout itemOtherRemindTime;
    private ImageView ivBack;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_setting);
        initView();
        initValue();
        initEvent();
    }

    @Override
    public void initView() {
        // TODO Auto-generated method stub
        itemNormalLastEndTime = (LinearLayout)this.findViewById(R.id.activity_date_setting_item_last_end_time);
        itemNormalLastStartTime = (LinearLayout)this.findViewById(R.id.activity_date_setting_item_last_start_time);
        itemNormalRemindTime  = (LinearLayout)this.findViewById(R.id.activity_date_setting_item_eveny_month_remind_time);
        itemOtherRemindTime   = (LinearLayout)this.findViewById(R.id.activity_date_setting_item_other_women_setting_time);
        ivBack = (ImageView)this.findViewById(R.id.include_appoinment_iv_back);
    }

    @Override
    public void initValue() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initEvent() {
        // TODO Auto-generated method stub
        ivBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				finish();
			}
		});
    }
}
