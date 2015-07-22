package cn.bubbycare.ibreast.bean;

import android.graphics.Bitmap;

/**
 * 我的预约 我要预约的医院 bean
 * */
public class HospitalBean {

	private String hospitalName;
	private String hospitalAdress;
	private Bitmap bitmap;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAdress() {
		return hospitalAdress;
	}

	public void setHospitalAdress(String hospitalAdress) {
		this.hospitalAdress = hospitalAdress;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

}
