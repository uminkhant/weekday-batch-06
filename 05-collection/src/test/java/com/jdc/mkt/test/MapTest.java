package com.jdc.mkt.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.Person;

public class MapTest {

	private Map<Integer, Person> map;
	private Person p1,p2,p3,p4;
	Map<Integer, Person> getMap(char s) {
		return switch (s) {
		case 'h' -> new HashMap<>();
		case 't' -> new TreeMap<>();
		case 'l' -> new LinkedHashMap<>();
		default -> null;
		};
	}
	
	void createPerson() {
		p1 = new Person("aa", 10);
		p2 = new Person("xx", 21);
		p3 = new Person("bb", 14);
		p4 = new Person("yy", 30);
	}
	
	void addValues() {
		map.put(1,p1);
		map.put(2,p2);
		map.put(3,p3);
		map.put(4,p4);
	}
	
	//@Test
	void test1() {
		map = getMap('t');
		createPerson();
		addValues();
		
		for(Entry<Integer,Person> e :map.entrySet()) {
			System.out.println(e.getKey() 
					+"\t"+e.getValue().getName());
		}
	}
	@Test
	void test2() {
		map = getMap('t');
		createPerson();
		addValues();
		map.remove(1);
	}
}
