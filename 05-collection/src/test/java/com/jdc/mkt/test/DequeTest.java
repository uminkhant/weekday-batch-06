package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class DequeTest {

	private Deque<String> d;
	
	Deque<String> getD(char str) {
		return switch (str) {
		case 'l' -> new LinkedList<>();
		case 'd' -> new ArrayDeque<>();
		default -> null;
		};
	}
	
	void addStringValues() {
		d.addLast("John");
		d.add("Satun");
		d.addFirst("Joshel");
		d.addLast("William");
		d.addLast("Joshel");
		d.addFirst("Sophia");
			
	}
	
	//@Test
	void test1() {
		d = getD('l');
		addStringValues();
		for(String s :d) {
			System.out.println(s);
		}
	}
	
	@Test
	void test2() {
		d = getD('l');
		addStringValues();
		assertEquals("Sophia", d.removeFirst());
		assertEquals("Joshel", d.pollLast());
	}
}
