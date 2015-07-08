package cn.bubbycare.ibreast.adapter;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.utils.Patient;

public class OneselfAdapter extends BaseAdapter{
	
	Context context;
	List<Patient> list;
	
	public OneselfAdapter(Context context,List<Patient> list){
		this.context = context;
		this.list = list;
	}
	
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		Patient patient =  list.get(arg0);
		ViewHolder viewHolder = null;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(context).inflate(R.layout.oneself_adapter, null);
			viewHolder.cancer = (TextView)view.findViewById(R.id.match_list_cancer);
			viewHolder.age = (TextView)view.findViewById(R.id.match_list_age);
			view.setTag(viewHolder);  
		}else {
			viewHolder = (ViewHolder) view.getTag();  
		}
			
		viewHolder.cancer.setText(patient.getCancer());
		viewHolder.age.setText(patient.getAge());
		return view;
	}
	
	private class ViewHolder{
		TextView cancer;
		TextView age;
	}

}
