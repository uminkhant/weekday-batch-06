package com.jdc.mkt.lsp;

public class Main {

	public static void main(String[] args) {
		Duck d = new ToyDuck();
		d.eat();
	}
	
}

class Duck{
	
	void eat() {
		System.out.println("Eat insects");
	}
}

class ToyDuck extends Duck {
	
	void eat() {
		throw new RuntimeException("Toy can't eat !");
	}
}
