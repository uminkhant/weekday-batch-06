package com.jdc.mkt.test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class OptionalTest {

	@Test
	void test1() {
		
		OptionalDouble dOpt= DoubleStream.of(5.1,23.0,21,1,3,2)
							.parallel()
							.filter(i -> i > 10)
							.findAny();
		
		Optional<String> opt = List.of("Andrew","William","Sopheia","Suasan")
								.stream()
								.filter(name -> name.startsWith("S"))
								.findFirst();
		
		
		OptionalInt iOpt = IntStream.of(2,1,5,6,1,7,8)
							.filter(f -> f > 10)
							.findFirst();
		
		//OptionalDouble
		System.out.println(dOpt.isPresent());
		
		//Optional
		//System.out.println(opt.get());
		String s = opt.orElse("No Name");
		System.out.println(s);
		
		String s1 = opt.orElseThrow(()-> new RuntimeException("No Value"));
		System.out.println(s1);
		
		String s2 = opt.map(n -> "Hello "+n).orElse("No Name");
		System.out.println(s2);
		 
		//OptionalInt
		iOpt.ifPresentOrElse(System.out::println,
				() -> System.out.println("There is no data"));
	}
	
	
}
