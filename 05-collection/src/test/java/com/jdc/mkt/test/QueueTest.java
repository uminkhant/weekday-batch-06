package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.jupiter.api.Test;

public class QueueTest {

	static Queue<String> q;
	
	Queue<String> getQ(char str) {
		return switch (str) {
		case 'l' -> new LinkedList<>();
		case 'b' -> new ArrayBlockingQueue<>(4);
		case 'd' -> new ArrayDeque<>();
		default -> null;
		};
	}
	
	void addStringValues() {
		q.add("John");
		q.add("Joshel");
		q.add("William");
		q.offer("Joshel");
		q.offer("Sophia");
			
	}

	@Test
	void test1() {
		q = getQ('l') ;
		addStringValues();
		assertTrue(q.offer("Other")) ;		
		assertEquals(6, q.size());
//		assertEquals("John",q.remove());
//		assertEquals("Joshel", q.peek());
//		assertEquals("Joshel", q.poll());
//		assertEquals(4, q.size());
	}
}
