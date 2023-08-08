package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class StreamTerminalTest {

	private List<Integer>list = Arrays.asList(3,2,1,5,4,7,2,8);
	@Test
	@Order(1)
	@DisplayName("1.Checking terminal ")
	void test1() {
		var res = list.stream().allMatch(a -> a > 0);
		assertTrue(res);
		var res1 = list.stream().anyMatch(a -> a > 7);
		assertTrue(res1);
		var res3 = list.stream().noneMatch(a -> a > 10);
		assertTrue(res3);
	}
	
	@Test
	@Order(2)
	@DisplayName("2.Result terminal ")
	void test2() {
		int i = list.stream().findFirst().get();
		System.out.println(i);
		int i2 = list.stream().findAny().get();
		System.out.println(i2);
		long count = list.stream()
				.skip(3)
				.count();
		System.out.println(count);
		
		Object[] array =  list.toArray();
		
		var l = list.stream()
		.filter(a-> a > 5)
		.collect(Collectors.toList());
		System.out.println(l.size());
		
		var x = list.stream().reduce((a,b)-> list.stream().mapToInt(s->s).sum()).get();
		System.out.println(x);
	}
	
}
