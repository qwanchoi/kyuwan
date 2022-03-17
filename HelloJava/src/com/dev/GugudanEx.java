package com.dev;

import com.edu.Student;

public class GugudanEx {
	public static void main(String[] args) {
//		for(int i = 1; i <= 5; i++) {
//			printStar(i, "★");
//			System.out.println();
//		}
		
//		gugudan(1234);
		int result = sum( sum(10, 20), sum(5, 7) );
		int[] newAry = { 10, 20, 30 };
		result = sum(newAry);
		
		System.out.println("결과는 " + result);
//		System.out.println(divide(10, 4));
		
	} // end of main()
	
	public static int sum(int[] ary) {
		// 배열매개변수의 각 요소의 합을 구하는 메소드.
		int sum = 0;
		for(int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}
	
	// 나누기 메소드 (int, int)
	public static double divide(int n1, int n2) {
		if (n2 == 0) {
			return 0;
		}
		return n1 / (double) n2;
	}
	
	public static int sum (int n1, int n2) {
		return n1 + n2;
	}
	
	public static void gugudan(int dan) {
		System.out.printf("[%d 단] \n", dan);
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d \n", dan, i, (dan*i));
		}
	}
	
	public static void printStar(int runCnt, String shape) {
		for(int i = 0; i < runCnt; i++) {
			System.out.print(shape);
		}
	} // end of printStart()
	
	public static void printGugudan() {
		// 메소드 실행하려면 new 클래스이름(); ex) Student s1 = new Student();
		// 
//		Student.callStatic();
		for(int j = 2; j <= 9; j++) {
			int cnt = j;
//			System.out.println("[" + cnt + "단]");
			for(int i = 1; i <= 9; i++) {
//				System.out.println(cnt + "*" + i + " = " + (i * cnt));
			}
		}
		
		
		String[] nLine = new String[10];
		for(int i = 0; i < nLine.length; i++) {
			nLine[i] = "";
		}
		for(int j = 2; j <= 5; j++) {
			int cnt = j;
			nLine[0] += "["+ cnt + "단]		";
			for(int i = 1; i <= 9; i++) {
				nLine[i] += cnt + " * " + i + " = " + (i * cnt) + "	";
			}
		}
		
		for( int i = 0 ; i < nLine.length; i++) {
			System.out.println(nLine[i]);
		}
		
		
	} // end of printGugudan()

}
