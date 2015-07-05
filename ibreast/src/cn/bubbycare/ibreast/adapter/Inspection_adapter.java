package cn.bubbycare.ibreast.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.bean.ResultBean;

/**
 * 专业检查适配器
 * */
public class Inspection_adapter extends BaseAdapter
{
	@SuppressWarnings("unused")
	private Context context;
	
	private List<ResultBean> list;
	
	private LayoutInflater inflater;
	public Inspection_adapter(Context context,List<ResultBean> list) {
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		convertView = inflater.inflate(R.layout.inspection_lv_item, null);
		
		TextView tv_data = (TextView)convertView.findViewById(R.id.inspection_item_time);
		TextView tv_category = (TextView)convertView.findViewById(R.id.inspection_category);
		TextView tv_result = (TextView)convertView.findViewById(R.id.inspection_result);
		
		tv_data.setText(list.get(position).getData());
		tv_category.setText(list.get(position).getCategory());
		tv_result.setText(list.get(position).getResult());
		Log.d("sky", "list.get(position).getCategory() = "+list.get(position).getCategory());
		return convertView;
	}
	
}
