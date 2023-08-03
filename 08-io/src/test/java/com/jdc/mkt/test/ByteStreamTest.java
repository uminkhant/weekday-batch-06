package com.jdc.mkt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ByteStreamTest {

	private static  File file;
	
	@BeforeAll
	static void init() throws IOException {
		file = new File("byte.txt");
		if(file.exists()) {
			file.createNewFile();
		}
	}
	
	@Test
	void test1() {
		writeFile();
		readFile();
	}

	private void readFile() {
		try(FileInputStream fIn = new FileInputStream(file)){
			int i = 0;
			
			while((i = fIn.read()) != -1) {
				char c = (char) i;
				System.out.print(c);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeFile() {
		try(FileOutputStream fout = new FileOutputStream(file)){
			byte[]array = "Hello".getBytes();
			for(byte b :array) {
				System.out.print(b+"\t");
			}
			System.out.println();
			fout.write(array);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
