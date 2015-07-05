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

public class Mine_My_Reservation extends BaseAdapter {

	private Context context;

	private List<HospitalBean> list;

	private LayoutInflater inflater;

	public Mine_My_Reservation(Context context, List<HospitalBean> list) {
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
		convertView = inflater.inflate(R.layout.item_my_appoinment, null);

		TextView tv_name = (TextView) convertView
				.findViewById(R.id.my_appoinment_item_tv_name);
		TextView tv_adress = (TextView) convertView
				.findViewById(R.id.my_appoinment_item_tv_adress);

		tv_name.setText(list.get(position).getHospitalName());
		tv_adress.setText(list.get(position).getHospitalAdress());
		return convertView;
	}

}
