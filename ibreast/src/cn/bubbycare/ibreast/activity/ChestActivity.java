package cn.bubbycare.ibreast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.interfaces.IActivity;
import cn.bubbycare.ibreast.view.ChestView;

public class ChestActivity extends Activity implements IActivity,
		OnClickListener, OnSeekBarChangeListener, OnCheckedChangeListener {

	private RadioGroup radioGroup;

	private RadioButton rbSoft;
	private RadioButton rbMiddle;
	private RadioButton rbHard;

	private ImageButton imgBtnAdd;
	private ImageButton imgBtnDelete;

	private SeekBar seekBar;
	private ChestView chestView;
	private int size = 1;
	private int degree = 1;
	private ImageView ivBack;
	private TextView txtTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_for_self);
		initView();
		initValue();
		initEvent();
		setCurrentPointValue(30, 50, 60, 3);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		radioGroup = (RadioGroup) this.findViewById(R.id.view_rg_layout);
		imgBtnAdd = (ImageButton) this.findViewById(R.id.view_imgbtn_add);
		imgBtnDelete = (ImageButton) this.findViewById(R.id.view_imgbtn_delete);
		rbSoft = (RadioButton) this.findViewById(R.id.view_rb_soft);
		rbMiddle = (RadioButton) this.findViewById(R.id.view_rb_middle);
		rbHard = (RadioButton) this.findViewById(R.id.view_rb_hard);
		seekBar = (SeekBar) this.findViewById(R.id.view_sb_selectnum);
		chestView = (ChestView) this.findViewById(R.id.view_chestview);
		txtTitle = (TextView) this
				.findViewById(R.id.include_appoinment_tv_title);
		ivBack = (ImageView) this.findViewById(R.id.include_appoinment_iv_back);
	}

	@Override
	public void initValue() {
		// TODO Auto-generated method stub
		txtTitle.setText(getString(R.string.string_selfremind_record));
	}
	
	/**
	 * 获取自定义View中肿块的位置坐标
	 */
	public void getCurrentPointValue()
	{
	    chestView.getPointX();
	    chestView.getPointY();
	}
	
	/**
	 * 设置本页面的属性值 用于在得到服务器数据后更新界面
	 */
	public void setCurrentPointValue(int x,int y,int size,int degree)
	{
	    chestView.setPointX(x);
	    chestView.setPointY(y);
	    seekBar.setProgress(size);
	    
        this.degree = degree;
        if(degree == ChestView.DEGREE_SOFT)
            chestView.changePointSizeOrDegree(ChestView.DEGREE_SOFT, size);
        else if(degree == ChestView.DEGREE_MIDDLE)
            chestView.changePointSizeOrDegree(ChestView.DEGREE_MIDDLE, size);
        else //if(degree == ChestView.DEGREE_HARD)
            chestView.changePointSizeOrDegree(ChestView.DEGREE_HARD, size);
//        chestView.changePointSizeOrDegree(degree, size);
//        radioGroup.
	}

	@Override
	public void initEvent() {
		// TODO Auto-generated method stub
		imgBtnAdd.setOnClickListener(this);
		imgBtnDelete.setOnClickListener(this);
		seekBar.setOnSeekBarChangeListener(this);
		radioGroup.setOnCheckedChangeListener(this);
		ivBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.view_imgbtn_add:
			chestView.addPoint();
			break;
		case R.id.view_imgbtn_delete:
			chestView.deletePoint();
			break;
		default:
			break;
		}
	}

	int lastValue = 0;

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
//		if (fromUser) {
			if (progress > 0 && progress <= 33) {
				size = 1;
			} else if (progress > 33 && progress <= 66) {
				size = 2;
			} else if (progress > 66 && progress < 99) {
				size = 3;
			}

			if (size != lastValue) {
				lastValue = size;
				chestView.changePointSizeOrDegree(degree, size);
			}

			// size = progress/33;
			// Log.i("XU", "size="+size+"   lastValue="+lastValue);
			// if(size != lastValue && size <
			// 3)//优化拖动事件,减少调用changePointSizeOrDegree的不必要次数,只有当size的值整点改动时才调用
			// {
			// size ++;
			// lastValue = size;
			// chestView.changePointSizeOrDegree(degree, size);
			// }
//		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// RadioButton button = (RadioButton)this.findViewById(checkedId);
		switch (checkedId) {
		case R.id.view_rb_soft:
			chestView.changePointSizeOrDegree(ChestView.DEGREE_SOFT, size);
			degree = ChestView.DEGREE_SOFT;
			break;
		case R.id.view_rb_middle:
			chestView.changePointSizeOrDegree(ChestView.DEGREE_MIDDLE, size);
			degree = ChestView.DEGREE_MIDDLE;
			break;
		case R.id.view_rb_hard:
			chestView.changePointSizeOrDegree(ChestView.DEGREE_HARD, size);
			degree = ChestView.DEGREE_HARD;
			break;
		default:
			break;
		}
	}
}
