package com.jdc.mkt.encapsulation;

public class Main {

	public static void main(String[] args) {
		Accessories ac = new KeyChain();
		ac.getThings("HandSet");
		
		//class cast exception
		Cover c = (Cover) ac ;
		c.doSomething();
		
	}
}

class KeyChain implements Accessories{
	String name ;
	@Override
	public void getThings(String type) {
		System.out.println("Key Chain use in "+type);
	}
	@Override
	public void doSomething() {
		System.out.println("From KeyChain");
	}
}
class Cover implements Accessories{
	@Override
	public void getThings(String type) {
		System.out.println("Cover use in"+type);
	}

	@Override
	public void doSomething() {
		System.out.println("From Cover");
	}
}

 interface Accessories{
	
	 void doSomething();
	 
	default void getThings(String type) {
		System.out.println("use "+type);
	}	
}
