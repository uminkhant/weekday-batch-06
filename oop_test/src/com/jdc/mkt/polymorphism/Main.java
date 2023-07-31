package com.jdc.mkt.polymorphism;

public class Main {

	public static void main(String[] args) {
		A aa = new B();
		aa.doSomething();
	}
}

interface MyInter{}
abstract class MyAbstract{}

class A extends MyAbstract implements MyInter{
	@Override
	public String toString() {
		return super.toString();
	}
	void doSomething() {
		System.out.println("do something form A");
	}
}
class B extends A{
	void doSomething() {
		System.out.println("do something form B");
	}
}
class C extends B{
	
	@Override
	public String toString() {
		return super.toString();
	}
	void doSomething() {
		System.out.println("do something form C");
	}
}
