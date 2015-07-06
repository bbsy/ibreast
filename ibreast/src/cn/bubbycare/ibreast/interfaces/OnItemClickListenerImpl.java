package cn.bubbycare.ibreast.interfaces;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.bubbycare.ibreast.activity.CheckRemindActivity;
import cn.bubbycare.ibreast.activity.MainActivity;
import cn.bubbycare.ibreast.adapter.CalendarAdapter;

public class OnItemClickListenerImpl implements OnItemClickListener {
	
	private CalendarAdapter adapter = null;
	private CheckRemindActivity activity = null;
	public OnItemClickListenerImpl(CalendarAdapter adapter, CheckRemindActivity activity) {
		this.adapter = adapter;
		this.activity = activity;
	}
	
	public void onItemClick(AdapterView<?> gridView, View view, int position, long id) {
		if (activity.currList.get(position).isThisMonth() == false) {
			return;
		}
		adapter.setSelectedPosition(position);  
		adapter.notifyDataSetInvalidated(); 
		activity.lastSelected = activity.currList.get(position).getDate();
	}
	
}
