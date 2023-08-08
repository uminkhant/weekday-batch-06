package com.jdc.mkt;

public class SampleMethod {
	
	public SampleMethod() {
		System.out.println("Default constructor ");
	}
	
	public SampleMethod(String name) {
		System.out.println("Using constructor with args :"+name);
	}
	
	public String message() {
		return "Hello ";
	}

	public void show(int i) {
		System.out.println("Method ref :"+i);
	}
	
	public static int converter(String str) {
		return Integer.parseInt(str);
	}
	
	public boolean isMale(String name) {
		return name.startsWith("Mr")?true:false;
	}
}
