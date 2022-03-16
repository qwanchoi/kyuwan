package com.prod;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String department;
	private String job;
	private int salary;
	
	// employeeId
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	
	// employeeName
	public void setEmployeeName(String name) {
		this.employeeName = name;
	}
	public String getEmployeeName() { 
		return this.employeeName;
	}
	
	// department
	public void setDepartment(String dep) {
		this.department = dep;
	}
	public String getDepartment() {
		return this.department;
	}
	
	// job
	public void setJob(String job) {
		this.job = job;
	}
	public String getJob() {
		return this.job;
	}
	
	// salary
	public void setSalary(int salary) {
		if(salary < 0) {
			this.salary = 10000;
		} else {			
			this.salary = salary;
		}
	}
	public int getSalary() {
		return this.salary;
	}
	
	public String getEmpInfo() {
		String result = 
			this.employeeName + "의 부서는 " 
			+ this.department + " 이고 직무는 " 
			+ this.job + " 이고 급여는 " 
			+ this.salary + "입니다. ";
		return result;
	}
	
}
