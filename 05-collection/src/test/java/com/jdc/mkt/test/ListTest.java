package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	private static ArrayList<String> list;
	
	void addStringValues() {
		list.add("John");
		list.add("Joshel");
		list.add("William");
		list.add("Joshel");
		list.add("Sophia");
	}
	@Test
	void test1() {
		list =  new ArrayList<String>();
		
		addStringValues();
		assertEquals(5, list.size());
		assertEquals("John", list.get(0));
		assertEquals(true, list.contains("Sophia"));
		String name = list.remove(1);
		assertEquals("Joshel", name);
		var index = list.indexOf("Sophia");
		assertTrue(index == 3);
		
		List<String> list1 = new ArrayList<String>();
		list1.addAll(list);
		assertEquals(4, list1.size());
		
		list.forEach(System.out::println);
		System.out.println("Hello");
		System.out.println("Hi");
	}
}
