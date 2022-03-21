package com.edu.shape;

public class ShapeExample {
    public static void main(String[] args) {
	Shape s1 = new Rectangle();
	Shape s2 = new Circle();
	Shape s3 = new Triangle();
	
	if(s1 instanceof Rectangle) {
	    Rectangle r1 = (Rectangle) s1;
	    r1.setWidth(12.3);
	    r1.setHeight(7.8);
	    System.out.println(r1.getArea());
	}
    }
}
