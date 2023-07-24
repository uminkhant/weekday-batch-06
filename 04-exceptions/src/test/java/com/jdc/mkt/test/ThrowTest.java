package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

public class ThrowTest {

	@Test
	void test1() {
		try {
			useException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void useException() throws Exception {
		getException();
	}
	
	void getException() throws Exception {
		throw new Exception();
	}
}
