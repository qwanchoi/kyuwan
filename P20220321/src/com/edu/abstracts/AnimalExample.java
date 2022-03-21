package com.edu.abstracts;

public class AnimalExample {
    public static void main(String[] args) {
	// Animal animal = new Animal(); // 추상클래스 인스턴스를 생성불가
	Animal animal = null;
	animal = new Dog();
	animal.setName("109");
	animal.eat();
	animal.speak();
	
	animal = new Cat();
	animal.setName("두부");
	animal.eat();
	animal.speak();
    }
}
