package com.edu.shape;

public class Circle extends Shape {
    private double radius;

    @Override
    public double getArea() {
	return radius * radius * 3.14;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
}
