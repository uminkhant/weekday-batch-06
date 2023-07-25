package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.MyException;

public class CustomExceptionTest {

	@Test
	void test1() {
		methodA();
	}

	void methodA() {
		try {
		methodB();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void methodB() throws MyException {
		throw new MyException("This is about custom exception");
	}
}
