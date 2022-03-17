package com.edu;

public class Student {
	// 필드(field)
	// 학생번호(uniq), 학생이름, 국어점수, 수학점수, 영어점수
	private int studNo;
	private String studName;
	private int korScore = -1;
	private int mathScore = -1;
	private int engScore = -1;
	
	// 영어, 국어, 수학 ==> 값이 저장되면 평균...
	public double getAvgScore() {
		return this.getSumScore() / 3.0;
	}
	
	// 영어, 국어, 수학 ==> 합계점수..
	public int getSumScore() {
		if(this.korScore != -1 && this.engScore != -1 && this.mathScore != -1) {
			return this.korScore + this.engScore + this.mathScore; 
		}
		return -1;
	}
	
	
	// 기능 (method) => 규칙 반환타입 메소드명 매개변수(parameter) {    }
	public void setStudNo(int studNo) {
		this.studNo = studNo;
	}
	public int getStudNo() {
		return this.studNo;
	}
	
	// studName
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	// korScore
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	// mathScore
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	// engScore
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
}
