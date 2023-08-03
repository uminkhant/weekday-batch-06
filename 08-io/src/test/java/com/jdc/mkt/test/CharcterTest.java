package com.jdc.mkt.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CharcterTest {

private static  File file;
	
	@BeforeAll
	static void init() throws IOException {
		file = new File("byte.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
	@Test
	void test1() {
		writeFile();
		readFile();
	}

	private void readFile() {
		try(FileReader fIn = new FileReader(file)){
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
		try(FileWriter fout = new FileWriter(file)){
			fout.write("Hello");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
