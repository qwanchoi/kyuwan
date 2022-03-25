package com.edu.io;

import java.io.Serializable;

public class Student implements Serializable {
    // 학생번호(1, 2, 3), 이름(홍길동), 영어(80), 국어(70)
    private int studentNo;
    private String name;
    private int engScore;
    private int korScore;
    
    public Student() { }
    public Student(int number, String name, int engScore, int korScore) {
	this.studentNo = number;
	this.name = name;
	this.engScore = engScore;
	this.korScore = korScore;
    }

    public int getNumber() {
        return studentNo;
    }

    public void setNumber(int number) {
        this.studentNo = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }
    
    // toString() => 재정의.
    @Override
    public String toString() {
	return "Student [number=" + studentNo + ", name=" + name + ", engScore=" + engScore + ", korScore=" + korScore
		+ "]";
    }
    
}
