package cn.bubbycare.ibreast.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import cn.bubbycare.ibreast.R;

public class RaceActivity extends Activity implements OnClickListener {

	Button bt;
	ImageView iv;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_race);
		init();
	}

	void init() {
		bt = (Button) this.findViewById(R.id.Race_next);
		iv = (ImageView) this.findViewById(R.id.Race_backtrack);
		bt.setOnClickListener(this);
		iv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Race_backtrack:
			finish();
			break;
		case R.id.Race_next:
			Intent it = new Intent(this,MenstruationActivity.class);
			startActivity(it);
			break;
		default:
			break;
		}
	}
}
