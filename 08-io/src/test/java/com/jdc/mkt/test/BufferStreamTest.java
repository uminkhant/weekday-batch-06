package com.jdc.mkt.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BufferStreamTest {

	private static File file;

	@BeforeAll
	static void init() throws IOException {
		file = new File("Buffer.txt");

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
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String str = null;
			
			while((str = bf.readLine()) != null) {
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeData() {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.write("Hello ");
			pw.append("Java");
			pw.println();
			pw.format("Hello %s", "Java");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
