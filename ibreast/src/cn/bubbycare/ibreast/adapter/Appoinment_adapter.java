package cn.bubbycare.ibreast.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.bean.HospitalBean;


/**
 * 我要预约适配器
 * */
public class Appoinment_adapter extends BaseAdapter {
	@SuppressWarnings("unused")
	private Context context;

	private List<HospitalBean> list;

	private LayoutInflater inflater;

	public Appoinment_adapter(Context context, List<HospitalBean> list) {
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
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.item_appoinment_lv, null);
		TextView tv_name = (TextView) convertView
				.findViewById(R.id.appoinment_item_tv_name);
		TextView tv_adress = (TextView) convertView
				.findViewById(R.id.appoinment_item_tv_adress);

		tv_name.setText(list.get(position).getHospitalName());
		tv_adress.setText(list.get(position).getHospitalAdress());
		return convertView;
	}

}
