package com.dev;

public class Account {
	// 계좌정보, 예금주, 잔액
	// field
	private String accNo;
	private String accName;
	private int money;
	
	// constructor: 생성자의 목적
	public Account(String accNo, String accName, int money) {
		this.accNo = accNo;
		this.accName = accName;
		this.money = money;
	}

	// method.
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accName=" + accName + ", money=" + money + "]";
	}
}
