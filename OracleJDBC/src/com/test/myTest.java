package com.test;

import java.io.UnsupportedEncodingException;

public class myTest {
    public static void main(String[] args) {
	
	String str1 = "";
	String str2 = "";
	
	String temp = "테스트金";
	
	str1 = "1234567890";
	str2 = myFormatter(10, temp);
	
	System.out.println(str1);
	System.out.println(str2);
    }
    
    public static String myFormatter(int len, String str) {
	byte[] bArr = null;
	try {
	    bArr = str.getBytes("EUC-KR");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	String temp = "";
	for(int i = 0; i < len-bArr.length; i++) {
	    temp += " ";
	}
	
	
//	byte[] bytes2 = str.getBytes("EUC-KR");
	return temp;
    }
}
