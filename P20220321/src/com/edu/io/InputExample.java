package com.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputExample {
    public static void main(String[] args) {
	
	try {
	    // 입력스트림을 생성(first.dat 파일을 입력스트림의 소스)
	    InputStream is = new FileInputStream("first.dat");
	    int readByte = 0;
	    while( (readByte = is.read()) != -1) {
		System.out.println(readByte);		
	    }
	    is.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
