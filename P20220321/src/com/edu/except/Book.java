package com.edu.except;

public class Book {
    private String title;
    private String author;
    private int price;
    
    public Book(String title, String author, int price) {
	this.title = title;
	this.author = author;
	this.price = price;
    }
    
    public void showInfo() {
	System.out.println("=========================");
	System.out.println("책제목: "+this.title + " 저자: " + this.author+ " 가격: " + this.price);
	System.out.println("=========================");
    }
}
