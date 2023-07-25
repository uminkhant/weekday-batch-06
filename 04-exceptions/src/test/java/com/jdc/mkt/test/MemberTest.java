package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.ExceptionDemo;
import com.jdc.mkt.Member;

public class MemberTest {

	static ExceptionDemo demo;
	
	@BeforeAll
	static void init() {
		demo = new ExceptionDemo();
	}
	
	@ParameterizedTest
	@DisplayName("Correct Member ")
	@CsvSource(value = "Su Su:admin:18",delimiter = ':')
	void test1(String name,String pass,int age) {
		
		Member m = demo.validate(name, pass, age);
		assertNotNull(m);
		assertEquals("Su Su", m.getName());
	}
	
	@ParameterizedTest
	@DisplayName("Incorrect password")
	@CsvSource(value = "Su Su:admn:12",delimiter = ':')
	void test2(String name,String pass,int age) {
		
		Member m = demo.validate(name, pass, age);
		Member member = demo.other(m);
		System.out.println(member.getName());
		//assertNotNull(m);
		//assertEquals("Su Su", m.getName());
	}
}
