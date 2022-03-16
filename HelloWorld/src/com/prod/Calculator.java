package com.prod;

public class Calculator {

	double PI = 3.14;

	// 메소드 정의 (매개변수, 매개변수)
	int add(int n1, int n2) {
		return n1 + n2;
	}

	// 반환 : int, 메소드명 : minus
	int minus(int v1, int v2) {
		return v1 - v2;
	}

	// 사각형의 넓이 계산..
	double getRectArea(double w, double h) {
		return w * h;
	}

	// 원의 넓이 계산..
	double getCircleArea(double radius) {
		return PI * radius * radius;
	}
}
