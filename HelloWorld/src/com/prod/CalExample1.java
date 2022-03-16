package com.prod;

public class CalExample1 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println(cal.PI);
		
		int number1 = 10;
		int number2 = 20;
		
		//			메소드 호출하는 부분 (매개값, 매개값);
		int result = cal.add(number1, number2);		
		System.out.println(number1+" 과(와) "+number2 + "의 합계: "+ result);
		
		result = cal.minus(number1, number2);		
		System.out.println(number1+" 과(와) "+number2 + "의 차이: "+ result);
		
		double area;
		area = cal.getRectArea(number1, number2);
		System.out.println(number1 + "과 " + number2 + "의 넓이: "+ area);
		
		double r = 4.5;
		area = cal.getCircleArea(r);
		System.out.println("반지름 "+ r +"의 넓이: " + area);
		
		System.out.println("end of prog");
	}
}
