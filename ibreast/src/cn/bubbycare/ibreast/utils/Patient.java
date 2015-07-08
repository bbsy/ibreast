package cn.bubbycare.ibreast.utils;

public class Patient {
	String cancer;
	String age;
	
	public String getCancer() {
		return cancer;
	}
	public void setCancer(String cancer) {
		this.cancer = cancer;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Patient(String cancer, String age) {
		super();
		this.cancer = cancer;
		this.age = age;
	}
	
	
}
