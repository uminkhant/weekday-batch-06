package com.jdc.mkt.test;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

	private Data data;
	
	@BeforeEach
	void init() {
		data = new Data();
	}
	
	@AfterEach
	void destroyed() {
		data = null;
	}
	@Test
	void test1() {
		data.methodA();
	}
	//@Test
	void test2() {
		
	}
}

class Data{
	
	void methodA() {
		methodB();
	}

	private void methodB() {
		
		try {
			methodC();
		}catch (Exception e) {
			System.out.println("This is divided by zero");
		}
	}

	private void methodC() throws IOException {
	
			//int i = 10/0;
			//.out.println(i);
			methodA();
		
		//File f = new File("c:/test.txt");
		//f.createNewFile();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
