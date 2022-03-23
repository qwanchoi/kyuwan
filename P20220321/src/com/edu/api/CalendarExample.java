package com.edu.api;

import java.util.Calendar;

public class CalendarExample {
    
    public static void main(String[] args) {

	int year = 2022;
	int month = 5; // 5월.

	createCalendar(year, month);

	System.out.println("\nend fo prog ...");
    }

    public static void createCalendar(int year, int month) {
	Calendar today = Calendar.getInstance();
	today.set(year, month - 1, 1);

//	System.out.println("올해는 : " + today.get(Calendar.YEAR));
//	System.out.println("이번달은: " + today.get(Calendar.MONTH) + 1); // 1월:0 2월:1 ... 12월:11
//	System.out.println("오늘은: " + today.get(Calendar.DATE));
//	System.out.println("요일정보: " + today.get(Calendar.DAY_OF_WEEK)); // 일:1 월:2 ... 토:7
//	System.out.println("마지막날의 정보: " + today.getActualMaximum(Calendar.DATE));

	int gapDay = today.get(Calendar.DAY_OF_WEEK);
	int lastDate = today.getActualMaximum(Calendar.DATE);

	System.out.printf("%12d 년 %2d 월\n", year, month );
	// 요일정보 출력.
	String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
	for (int i = 0; i < days.length; i++) {
	    System.out.printf("%4s", days[i]);
	}
	System.out.println();

	// 1일의 위치 지정
	for (int i = 1; i < gapDay; i++) {
	    System.out.printf("%4s", "");
	}

	// 일 출력
	for (int i = 1; i <= lastDate; i++) {
	    System.out.printf("%4d", i);
	    if ((i + gapDay - 1) % 7 == 0) {
		System.out.println();
	    }
	}
    }
}
