package com.edu.api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
	Date today = new Date();
	today.setYear(2020 - 1900);
	System.out.println(today);
	
	SimpleDateFormat sdf = null; 
	sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
	sdf = new SimpleDateFormat("yy-MM-dd");
	System.out.println(sdf.format(today));
	
	LocalDateTime time = LocalDateTime.now();
	System.out.println(time.getYear() + "년");
	
	
    }
}
