package com.edu.except;

import java.util.Calendar;
import java.util.Scanner;

//class String2 extends String {
//    // public final String {} // 상속불가능한 클래스.
//}

public class ExceptionExample2 {
    public static void main(String[] args) {

	// Object 
	Object obj = new String();
	obj = new Scanner(System.in);
	obj = Calendar.getInstance();
	
	obj = new Object();
	System.out.println("obj의 해시코드: " + obj.hashCode());
	
	//Exception 컴파일 시 발생 > 컴파일 불가 
	try {
	    Class.forName("java.lang.String1");
	} catch (ClassNotFoundException e1) {
//	    e1.printStackTrace();
	    System.out.println("해당 클래스가 존재하지 않습니다.");
	}
	
	// RuntimeException -> 런타임 시 발생 > 개발자 역량
	String str = null;
	try {
	    str.charAt(0); // CharSequence interface의 추상메소드.
	    System.out.println(str.toString());
	} catch (NullPointerException e) {
	    System.out.println("널포인트 예외발생.");
	    e.printStackTrace();
	}
	
	String nums1 = "백";
	String nums2 = "이백";
	int num1 = 0, num2 = 0;
	try {
	    num1 = Integer.parseInt(nums1); // int 변환
	    num2 = Integer.parseInt(nums2);
	    
	    str.charAt(0);
	} catch (NumberFormatException e) {
	    num1 = 0;
	    num2 = 0;
	} catch (Exception e2) {
	    System.out.println("상위의 예외발생...");
	}
	System.out.println(num1+" + " + num2 + " = " + (num1 + num2));
	
	try {
	    showError();	    
	} catch(ClassNotFoundException e) {	    
	    e.printStackTrace();
	}
	
	System.out.println("end of program...");
    } // end of main()
    
    public static void showError() throws ClassNotFoundException {
	Class.forName("java.lang.Strings");
    }
    
//    public static void showError() {
//	try {
//	    Class.forName("java.lang.Strings");
//	} catch (ClassNotFoundException e) {
////	    e.printStackTrace();
//	    System.out.println("예외발생.");
//	}
//	
//    }
} // end of class
