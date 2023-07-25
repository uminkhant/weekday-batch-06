package com.jdc.mkt.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class CatchTest {

	static Animal an;

	@Test
	@DisplayName("1. try catch")
	@Order(1)
	void test1() {
		try {
			an = new Animal();
			an.name = "Hello";
			System.out.println(an.name);

		} catch (NullPointerException e) {
			System.out.println("Null value");
		}
	}

	@Test
	@DisplayName("2. multicatch ")
	@Order(2)
	void test2() {
		try {
			an.name = "Hi";
			int res = 10 / 0;
			System.out.println(an.name + res);

		} catch (NullPointerException e) {
			System.out.println("Null ex");
		} catch (ArithmeticException e) {
			System.out.println("Runtime ex");
		}
	}

	@Test
	@DisplayName("3. try multicatch")
	@Order(3)
	void test3() {
		try {
			an.name = "Hello";
			System.out.println(an.name);
			

		} catch (NullPointerException | ArithmeticException e) {
			System.out.println("Null value");
		}
	}

	@Test
	@DisplayName("4. try catch finally")
	@Order(4)
	void test4() {
		try {
			an.name = "Hello";
			System.out.println(an.name);

		} catch (NullPointerException e) {
			System.out.println("Null value");
		} finally {
			System.out.println("Finally statement");
		}
	}

	@Test
	@DisplayName("5. try with resource")
	@Order(5)
	void test5() throws Exception {

		try (var h = new Human()) {
			an.name = "Hello";
			System.out.println(an.name);

		} catch (NullPointerException e) {
			System.out.println("Null value");
		}
	}

}

class Animal {
	String name;
}

class Human implements AutoCloseable {

	@Override
	public void close() throws Exception {

	}
}
