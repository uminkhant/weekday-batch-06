package com.jdc.mkt.generic;

public class BoundedTypeDemo {

	public static void main(String[] args) {
		Draw<Rectangle> sq = new Draw<>();
		sq.getShape(new Rectangle());		
	}
}


class Square implements Shape{

	@Override
	public void draw() {
		
	}}
class Rectangle implements Shape{

	@Override
	public void draw() {
		
	}}
interface Shape{
	void draw();
}

class Draw<T extends Shape>{
	
	void getShape(T t) {
		System.out.println(t);
	}
	
}
