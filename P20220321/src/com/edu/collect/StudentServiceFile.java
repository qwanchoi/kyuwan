package com.edu.collect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceFile implements StudentService {

    List<Student> list = new ArrayList<Student>();
    File file;

    @Override
    public void insertStudent(Student student) {
	list.add(student);
    }

    @Override
    public Student getStudent(int sno) {
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getNumber() == sno) {
		return list.get(i);
	    }
	}
	return null;
    }

    @Override
    public List<Student> studentList() {
	return list;
    }

    @Override
    public void modifyStudent(Student student) {
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getNumber() == student.getNumber()) {
		list.get(i).setEngScore(student.getEngScore()); // 영어점수
		list.get(i).setKorScore(student.getKorScore()); // 국어점수
	    }
	}
    }

    @Override
    public void removeStudent(int sno) {
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getNumber() == sno) {
		list.remove(i);
	    }
	}
    }

    @Override
    public List<Student> searchStudent(String name) {
	List<Student> searchList = new ArrayList<Student>();
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getName().equals(name)) {
		searchList.add(list.get(i));
	    }
	}
	return searchList;
    }

    @Override
    public void saveToFile() {
	// 작성했던 ArrayList<Student> list => 파일저장.
	try {
	    FileWriter fw = new FileWriter("studentList.data");
	    BufferedWriter bw = new BufferedWriter(fw);

	    for (Student stud : list) {
		bw.write(stud.getNumber() + "," + stud.getName() + "," + stud.getEngScore() + "," + stud.getKorScore());
	    }
	    bw.close();
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
