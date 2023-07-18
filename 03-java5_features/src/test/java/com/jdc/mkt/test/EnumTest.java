package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.enumTest.Day;
import com.jdc.mkt.enumTest.EnumDemo;

public class EnumTest {

	//@Test
	void test1() {
		EnumDemo d = new EnumDemo();
		d.useConstant();
	}
	//@Test
	void test2() {
		EnumDemo d = new EnumDemo();
		d.showConstants();
	}
	
	@Test
	void test3() {
		EnumDemo d = new EnumDemo();
		Day day = Day.SUN;
		//from abstract method
		day.showFullName();
		//name from constructor
		String s = day.getName();
		System.out.println(s);
		//use switch case
		d.usingSwitch(day);
		
		//use with interface
		day.doWork();
	}
	
	
}
