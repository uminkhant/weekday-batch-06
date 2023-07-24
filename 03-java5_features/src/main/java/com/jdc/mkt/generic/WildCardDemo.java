package com.jdc.mkt.generic;

public class WildCardDemo {

	public static void main(String[] args) {
		Color<Object> color = new Color<>();
		//upperBound(color);
		lowerBond(color);
	}
	
	static void upperBound(Color<? extends B> color) {
		//color.setT(new C());
		System.out.println(color.getT());
	}
	static void lowerBond(Color<? super B> color) {
		color.setT(new C());
		System.out.println(color.getT());
	}
}

class AA{}
class B extends AA{}
class C extends B{}
class D extends C{}

class Color<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
