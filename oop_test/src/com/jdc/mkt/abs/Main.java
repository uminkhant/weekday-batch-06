package com.jdc.mkt.abs;

class Main {

	public static void main(String[] args) {
		Color c = new Rectangle();
		c.useColor();
		c.show();
	}
}

abstract class Shape extends Color {
	abstract void draw();

}

abstract class Color {

	String name;
	static String age;

	abstract void useColor();

	Color() {
		System.out.println("Color");
	}

	void show() {
		System.out.println("Showing");
	}

	

	private static void doSomething() {
	}
}

class Square extends Shape {

	@Override
	void useColor() {
		System.out.println("Square is use brown color");
	}

	@Override
	void draw() {

	}

}

class Rectangle extends Shape {

	public Rectangle() {
		super();
	}

	@Override
	void useColor() {
		System.out.println("Rectangle is use brown color");
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub

	}

}

class Circle extends Shape {

	@Override
	void useColor() {
		System.out.println("Circle is use brown color");
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub

	}

}
