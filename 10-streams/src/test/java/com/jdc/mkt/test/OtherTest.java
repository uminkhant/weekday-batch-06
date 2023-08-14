package com.jdc.mkt.test;

import java.util.List;

import org.junit.jupiter.api.Test;

public class OtherTest {

	@Test
	void test1() {
		List.of(2,3,4,1,2,1,4,5,6)
		.stream()
		.sorted()
		.parallel()
		.dropWhile(i -> i > 1)
		.forEach(System.out::println);;
	}
}
