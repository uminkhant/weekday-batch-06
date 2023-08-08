package com.jdc.mkt;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		MyInter1 i1 = s ->{
			String n = "Java";
			System.out.println("Hello "+n);
		};
		i1.show("ss");
		MethodReferenceDemo demo = new MethodReferenceDemo();
		MyInter1 i2 = demo::doSomething;
		i2.show("ss");
		
		System.out.println("------------------ === -------------");
		
		MyInter2 i3 = str -> Integer.parseInt(str);
		int res = i3.convert("30");
		System.out.println("Lambda : "+(res+3));
		
		OtherClass o = new OtherClass();
		MyInter2 i4 = o::converter;
		int res2 = i4.convert("50");
		System.out.println("Method ref : "+res2);
		
		MyInter2 i5 = OtherClass::ConvertToString;
		int res3 = i5.convert("60");
		System.out.println("Static Method ref :"+res3);
		System.out.println("------------------ === -------------");
		
		MyInter1 i6 = OtherClass::new;
		i6.show("ssss");
		
	}
	
	void doSomething(String s) {
		System.out.println("Do Something");
	}
}

class OtherClass{
	
	public OtherClass() {
		super();
		System.out.println("Constructor without args .");
	}
	
	OtherClass(String s){
		System.out.println("Constructor with args :"+s);
	}
	int converter(String s) {
		return Integer.valueOf(s)+20;
	}
	
	static int ConvertToString(String s) {
		return Integer.parseInt(s);
	}
}

@FunctionalInterface
interface MyInter1{
	void show(String s);
	
}
@FunctionalInterface
interface MyInter2{
	int convert(String s);
}




