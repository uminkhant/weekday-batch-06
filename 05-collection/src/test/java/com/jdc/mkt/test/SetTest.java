package com.jdc.mkt.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class SetTest {

	private  Set<String> set;

	@BeforeEach
	void create() {
		set = getImpl("link");		
		//addPersons();
		addStringValues();
	}
//	void addPersons() {
//		set.add(new Person("Andrew", 30));
//		set.add(new Person("William", 45));
//		set.add(new Person("Sophia", 23));
//		set.add(new Person("Samlew", 41));
//		set.add(new Person("Upul Sampah", 31));
//	}
	
	void addStringValues() {
		set.add("Sandar");
		set.add("Zay ya");
		set.add("Aung Aung");
		set.add("Sandar");
		set.add("wanna");
		set.add("Thida");
		set.add("Sandar");
	}

	Set<String> getImpl(String name) {
		return switch (name) {
		case "hash" -> new HashSet<>();
		case "tree" -> new TreeSet<>();
		case "link" -> new LinkedHashSet<>();
		default -> null;
		};
	}

	@Test
	@Order(1)
	@DisplayName("1.show all elements")
	void test1() {
		
		for(String s :set) {
			System.out.println(s);
		}
		//System.out.println("Using iterator obj");
		
//		Iterator<String> itr = set.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
	}
//	@ParameterizedTest
//	@Order(2)
//	@ValueSource(strings = "wanna")
//	void test2(String name) {
//		var res = set.remove(name);
//		assertTrue(res);
//		res = set.add(name);
//		assertTrue(res);
//		assertEquals(5, set.size());
//		res = set.contains(name);
//		assertTrue(res);
//	}
	
	
}
