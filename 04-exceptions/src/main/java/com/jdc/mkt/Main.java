package com.jdc.mkt;

public class Main {

	Hello h;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.method1();
		m.method2();
		
	}
	 void method1() {
		h = new Hello();
		h.name = "ss";
		System.out.println(h.name);
	}
	 void method2() {
		 h.name = "hi";
		 System.out.println(h.name);
	 }
}
class Hello{
	String name ;
}
