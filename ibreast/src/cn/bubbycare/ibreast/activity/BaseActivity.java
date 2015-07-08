package cn.bubbycare.ibreast.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    @SuppressWarnings("unused")
	private void addActionBar() 
    {
        ActionBar actionBar = getActionBar();
//        actionBar.set
    }
}
