package com.jdc.mkt.generic;

public class GenericMethodDemo {

	public static void main(String[] args) {
		Container<String> con = new Container<>();
		compare(con);
		getValue(con);
	}
	
	static<T> void compare(Container<T> t) {
		System.out.println(t.getValue());
	}
	
	static<T>T getValue(Container<T> t) {
		return t.getValue();
	}
}

class Container<T>{
	T t;
	T getValue() {
		return  t;
	}
}
