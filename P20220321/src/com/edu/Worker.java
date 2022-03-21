package com.edu;

public class Worker extends Person {
	// 직장명, 직급 : 이름, 나이, 키, 몸무게
	private String company;
	private String job;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
