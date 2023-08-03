package com.jdc.mkt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ObjectStreamTest {

	private static File file;

	@BeforeAll
	static void init() throws IOException {
		file = new File("Data.obj");

		if (!file.exists()) {
			file.createNewFile();
		}
	}

	@Test
	void test1() {
		writeData();
		readData();
	}

	private void readData() {
		try (ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream(file))) {
			
//			Person d = (Person) in.readObject();
//			System.out.println(d.getId() + "\t" +d.getName());
			
			String str = in.readUTF();
			System.out.println(str);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeData() {
		try (ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream(file))) {
			
//			Person d = new Person();
//			d.setId(1);
//			d.setName("Andrew ");			
//			out.writeObject(d);
			
			out.writeUTF("Hello java");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}

class Person implements Serializable{

private static final long serialVersionUID = 5712487859885923101L;
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}



