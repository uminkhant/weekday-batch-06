package com.jdc.mkt.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class StreamCreateTest {


	@Test
	@Order(1)
	@DisplayName("1.Before and after streams")
	void test1() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		int before = sum(list);
		System.out.println(before);
		
		int after = list.stream().mapToInt(a -> a).sum();
		System.out.println(after);
	}
	
	@Test
	@Order(2)
	@DisplayName("2.Stream from Arrays or collections")
	void test2() {
		Arrays.asList("John","William","Andrew")
		.stream()
		.forEach(System.out::println);
		
		Collection<String> col = Arrays.asList("ss","aa","bb");
		col.stream().forEach(s -> System.out.println(s));
	}
	@Test
	@Order(3)
	@DisplayName("3.Stream from range")
	void test3() {
		var sum = IntStream.range(1, 11).sum();
		System.out.println(sum);
		var sum1 = IntStream.rangeClosed(1, 11).sum();
		System.out.println(sum1);
		var sum2 = LongStream.of(233,433,233).sum();
		System.out.println(sum2);
	}
	
	@Test
	@Order(4)
	@DisplayName("4.Stream from generate and itreate")
	void test4() {
		DoubleStream.generate(Math::random).limit(5).forEach(System.out::println);
		IntStream.iterate(1, a -> a+2).limit(5).forEach(System.out::println);
	}
	
	int sum(List<Integer> list) {
		int sum = 0;
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			sum += itr.next();
		}
		return sum;
	}
}
