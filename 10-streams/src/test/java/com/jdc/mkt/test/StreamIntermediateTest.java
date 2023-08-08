package com.jdc.mkt.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamIntermediateTest {

	List<Integer> list = Arrays.asList(3, 4, 5, 6, 22, 1, 6, 7, 8, 21, 33, 33, 22, 43);

	@Test
	void test1() {
		System.out.print("Using filter,distinct :");
		 list.stream()
				.filter(i -> i > 10)
				.distinct()
				.forEach(l -> System.out.print(l+" "));	 
		 System.out.println();
		 
		 System.out.print("Using sorted :");		 
		 list.stream()
		 .sorted()
		 .forEachOrdered(l -> System.out.print(l+" "));	
		 System.out.println();
		 
		 System.out.print("Using skip 3 :");
		 list.stream()
		 .skip(3)
		 .forEach(nul -> System.out.print(nul+" "));
		 System.out.println();
		 
		 System.out.print("Using Map :");
		 list.stream()
		 .map(String::valueOf).forEach(System.out::print);
		 System.out.println();
		 
		 Stream.of(List.of(1,2,3),List.of(6,5,4))
		 .flatMap(list -> list.stream())
		 .skip(2)
		 .findAny();
	}
}
