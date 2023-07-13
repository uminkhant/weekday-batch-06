package com.jdc.mkt.inter;

public class Main {

	
	public static void main(String[] args) {
		Animal an = new Lion();
		an.eat();
	}
}

interface Animal {
	
	static String name = "no name";
	
	 void eat();
		 
	static void doSomething() {}
}

interface Color{
	void skinColor();
}

abstract class MyAbstract implements Color,Animal{
	
}

class Lion extends MyAbstract{

	@Override
	public void eat() {
		System.out.println("Lion :Eat Something");
	}

	@Override
	public void skinColor() {
		// TODO Auto-generated method stub
		
	}}

class Fox implements Animal{

	@Override
	public void eat() {
		System.out.println("Fox :Eat Something");
	}
	
}
