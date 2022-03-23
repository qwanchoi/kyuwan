package com.edu.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {

	Set<String> set = new HashSet<String>(); // Set:중복값은 허용X
	set.add("hello");
	set.add("World");
	set.add("Good");
	set.add("World"); // 중복된 요소는 추가불가.
	set.remove("Good");
	
	System.out.println("set 크기: " + set.size());

	Iterator<String> iter = set.iterator(); // 반복자
	while (iter.hasNext()) {
	    String result = iter.next();
	    System.out.println(result);
	}
	
	System.out.println("end of prog");
    }
}
