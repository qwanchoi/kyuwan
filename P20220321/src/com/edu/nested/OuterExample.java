package com.edu.nested;

public class OuterExample {
    public static void main(String[] args) {
	Outer outer = new Outer();
//	outer.method1();
//	outer.method3();
	outer.method4();
	
	System.out.println("----- Inner -----");
	Outer.Inner inner = outer.new Inner(); // 생성자 차이
//	inner.method2();
	
    }
}
