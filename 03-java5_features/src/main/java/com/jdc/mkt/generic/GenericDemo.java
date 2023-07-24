package com.jdc.mkt.generic;

public class GenericDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		Data<String> data =  new Data<>();
		data.setValue("String value");
		String s = data.getValue();
		System.out.println(s);
		
		Data<A> dataA = new Data<>();
		dataA.setValue(new A());
		A a = dataA.getValue();
		System.out.println(a.show());
		
		
		Data<Integer> dataInt = new Data<>();
		dataInt.setValue(45);		
		int i = dataInt.getValue();
		
	}
}

class A {
	String show() {
		return "From A";
	}
}

class Data<T>{
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
}







