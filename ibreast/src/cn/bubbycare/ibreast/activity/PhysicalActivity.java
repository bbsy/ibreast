package cn.bubbycare.ibreast.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import cn.bubbycare.ibreast.R;

public class PhysicalActivity extends Activity implements OnClickListener {

	Button bt;
	ImageView iv;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physical);
		init();
		}

		void init() {
			bt = (Button) this.findViewById(R.id.physical_next);
			iv = (ImageView) this.findViewById(R.id.Physical_backtrack);
			bt.setOnClickListener(this);
			iv.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.Physical_backtrack:
				finish();
				break;
			case R.id.physical_next:
				Intent it = new Intent(this,RaceActivity.class);
				startActivity(it);
				break;
			default:
				break;
			}
		}
}
