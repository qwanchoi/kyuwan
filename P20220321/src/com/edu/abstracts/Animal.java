package com.edu.abstracts;

public abstract class Animal {
    private String name;

    public Animal() {
	System.out.println("Animal() 생성자 호출.");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // 추상메소드 정의.
    public abstract void eat();
    
    public abstract void speak();
}
