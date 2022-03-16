package com.prod;

public class User {
	private String name;
	private String grade;
	private String phone;
	private int point;
	
	public String getUserInfo() {
		String info = 
			this.name + "의 등급: "
			+this.grade +", 연락처: "
			+this.phone + ", 포인트: "
			+this.point;
		return info;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
