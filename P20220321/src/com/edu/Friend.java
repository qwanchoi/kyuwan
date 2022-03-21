package com.edu;

public class Friend extends Person {
	// 연락처 : 이름, 나이, 키, 몸무게	-> 회사: 회사이름, 회사업무
	// 									-> 학교: 학교이름, 전공
	
	private String phone;
	
	// 생성자 없으면 컴파일러가 내부적으로 기본생성자 생성
	// public Friend() {} => super() // : 부모 생성자 먼저 실행
	public Friend() { }
	public Friend(String name, int age, double height, double weight, String phone) {
		super(name, age, height, weight);
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// overriding => 부모클래스 메소드 - 자식클래스가 새롭게 정의.
	@Override // annotation
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + " 이고 \n";
		str += "나이는 " + super.getAge() + " 이고 \n";
		str += "연락처는 " + this.getPhone() + " 입니다. \n";
		return str;
	}
	
}
