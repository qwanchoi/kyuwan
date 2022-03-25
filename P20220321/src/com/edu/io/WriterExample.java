package com.edu.io;

import java.io.FileWriter;
import java.io.IOException;

public class WriterExample {
    public static void main(String[] args) {
	// 츨력스트림 문자기반으로 second.txt
	try {
	    FileWriter fw = new FileWriter("second.txt");
	    fw.write("Hello \n");
	    fw.write("World \n");
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	System.out.println("end of program...");
    }
}
