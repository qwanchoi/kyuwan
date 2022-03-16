package com.prod;

public class Car {
	private int maxSpeed;
	private String model;
	private int speed;
	
	public void addSpeed() {
		if(this.speed + 10 > this.maxSpeed) {
			System.out.print(" 탈탈탈!!! ");
			return;
		}
		System.out.print("부아아아아아앙!!! ");
		this.speed += 10;
	}
	
	public void breakSpeed() {
		System.out.print("끼이이이익!!! ");
		this.speed -= 10;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}
	
	
}
