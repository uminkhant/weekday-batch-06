package com.jdc.mkt.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DataStreamTest {

	private static File file;

	@BeforeAll
	static void init() throws IOException {
		file = new File("Data.dat");

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
		try (DataInputStream dIn = 
				new DataInputStream(new FileInputStream(file))) {
			String s = dIn.readUTF();
			System.out.println(s + "\t" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeData() {
		try (DataOutputStream dOut = new DataOutputStream
				(new FileOutputStream(file))) {
			dOut.writeUTF("Andrew william John");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
