package com.edu.abstracts;

public class Dog extends Animal {
    
    public Dog() {
//	super(); // 주석처리 해도 부모생성자 호출
	System.out.println("Dog() 생성자 호출");
    }
    
    @Override
    public void eat() {
	System.out.println("멍멍이가 먹습니다.");
    }
    
    @Override
    public void speak() {
        System.out.println("멍멍멍");
    }
    
}
