package com.edu.shape;

public class Triangle extends Shape {
    
    private double base;
    private double height;
    
    @Override
    public double getArea() {
	return base * height / 2;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    
}
