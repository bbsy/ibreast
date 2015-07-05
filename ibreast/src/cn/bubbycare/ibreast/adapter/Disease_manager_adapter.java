package cn.bubbycare.ibreast.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.bean.DiseaseBean;


/**
 * 病例管理适配器
 * */
public class Disease_manager_adapter extends BaseAdapter {
	private Context context;

	private List<DiseaseBean> list;

	private LayoutInflater inflater;

	public Disease_manager_adapter(Context context, List<DiseaseBean> list) {
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
		convertView = inflater.inflate(R.layout.mine_manager_lv_item, null);

		TextView tv_advice = (TextView) convertView
				.findViewById(R.id.mine_manager_advice);
		TextView tv_result = (TextView) convertView
				.findViewById(R.id.mine_manager_result);
		ImageView iv_bitmap = (ImageView) convertView
				.findViewById(R.id.mine_manager_item_iv_mimi);

		tv_advice.setText(list.get(position).getAdvice());
		tv_result.setText(list.get(position).getResult());

		if (list.get(position).getBitmap() != null) {
			iv_bitmap.setImageBitmap(list.get(position).getBitmap());
			iv_bitmap.setVisibility(View.VISIBLE);
		} else {
			iv_bitmap.setVisibility(View.GONE);
		}
		return convertView;
	}
}
