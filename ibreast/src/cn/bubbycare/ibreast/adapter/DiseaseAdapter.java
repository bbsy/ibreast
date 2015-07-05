package cn.bubbycare.ibreast.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.bean.DiseaseBean;

public class DiseaseAdapter extends BaseAdapter {

	private Context context;
	
	private List<DiseaseBean> list;
	
	LayoutInflater inflater;
	public DiseaseAdapter(Context context, List<DiseaseBean> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		convertView = inflater.inflate(R.layout.disease_knowledge_item,null);
		TextView tv_introduction = (TextView)convertView.findViewById(R.id.disease_item_tv_introduction);
		TextView tv_time = (TextView)convertView.findViewById(R.id.disease_item_tv_time);
		
		tv_introduction.setText(list.get(position).getIntroduce());
		tv_time.setText(list.get(position).getTime());
		return convertView;
	}

}
