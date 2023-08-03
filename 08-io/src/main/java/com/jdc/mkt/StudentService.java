package com.jdc.mkt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentService {
	private File file;
	private static Student[] students = new Student[0];

	public StudentService() throws IOException {
		file = new File("students.obj");
		
		if(!file.exists()) {
			file.createNewFile();
			writeToFile();
		}
		
		if(readFromFile() != null) {
			students = readFromFile();
		}

	}

	public void addStudent(Student student) {
		Student[] temp = new Student[students.length + 1];
		for (int x = 0; x < students.length; x++) {
			temp[x] = students[x];
		}
		temp[students.length] = student;
		students = temp;

	}

	public Student[] getStudents() {
		return students;
	}

	public Student[] readFromFile() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				
				Student[] array = (Student[]) in.readObject();				
				return array;

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void writeToFile() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(students);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}