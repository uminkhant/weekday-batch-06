package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAnnoTest {

	@Test
	void test5() {
		System.out.println("Using Test 5");
	}
	@Test
	void test6() {
		System.out.println("Using Test 6");
	}
	@BeforeAll
	static void test1() {
		System.out.println("Using Before All");
	}
	@AfterAll
	static void test2() {
		System.out.println("Using After All");
	}
	@BeforeEach
	void test3() {
		System.out.println("Using Before Each");
	}
	@AfterEach
	void test4() {
		System.out.println("Using After Each");
	}
	
	
	
}
