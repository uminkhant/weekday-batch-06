package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.SampleMethod;

public class FunctionalTest {

	//@Test
	@DisplayName("1.Using Functional interface with one arg")
	void test1() {
		SampleMethod m = new SampleMethod();
		
		System.out.println("........... Using consumer interface ......");
		Consumer<Integer> c1 = a -> System.out.println("Lambda :"+a);
		c1.accept(3);
		
		Consumer<Integer> c2 = m::show;
		c2.accept(3);
		
		System.out.println("............. Using function interface ......");
		Function<Integer, String> f1 = i -> String.valueOf(i);
		System.out.println("Lambda :"+f1.apply(30));
		Function<String, Boolean> f2 = m::isMale;	
		var res = f2. apply("Mr.William");
		assertTrue(res);
		System.out.println("Method ref :"+res);
		
		System.out.println("............. Using Predicate interface ......");
		Predicate<String> p1 = m::isMale;
		var res2 = p1.test("MM");
		assertFalse(res2);
		System.out.println("Method ref :"+res2);
		
	}
	
	//@Test
	@DisplayName("2.Using functional interface with two args")
	void test2() {
		BiPredicate<Integer, Integer> p1 = (a,b) -> a%b == 0;
		var v = p1.test(10, 5);
		System.out.println("lambda result :"+v);
		assertTrue(v);
		
		BinaryOperator<Integer> plus = (a,b) -> a+b;
		int res = plus.apply(5, 3);
		System.out.println("lambda result :"+res);
		assertEquals(8, res);
		
		BiFunction<Integer, Integer, String> f1 = (a,b) -> 
		a%b == 0 ? "Remainder is zero":"Remainder is not zero"; 
		var message = f1.apply(15, 3);
		System.out.println(message);
	}
	@Test
	@DisplayName("Using functional interface with default method andThen  ")
	void test3() {
		Function<Integer, String> f1 = i -> String.valueOf(i);
		String s = f1.apply(30);
		Function<String,Integer> f2 = str -> Integer.parseInt(str);
		int ints = f2.apply(s);
		System.out.println("Use with +2:"+(ints+2));
		
		int res = f1.andThen(f2).apply(ints);
		System.out.println("use andThen with +2 :"+(res+2));
		
		Consumer<String> c1 = c -> System.out.println(c);
		c1.andThen(ss -> System.out.println("Hello :"+ss)).accept("Java");
	}
	
	
	
	
}
