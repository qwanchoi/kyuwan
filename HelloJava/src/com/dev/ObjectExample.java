package com.dev;

import java.util.Scanner;

import com.edu.Student;

public class ObjectExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setStudNo(100);
		s1.setStudName("blue");
		
		Scanner scn = new Scanner(System.in);
		scn.nextInt();
		
		System.out.println("end of prog");
	}
}
