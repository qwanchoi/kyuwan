package com.edu.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExample {
    public static void main(String[] args) {
	try {
	    OutputStream os = new FileOutputStream("first.dat");
	    os.write(10);
	    os.write(20);
	    os.write(30);
	    os.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	System.out.println("end of progam");
    }
}
