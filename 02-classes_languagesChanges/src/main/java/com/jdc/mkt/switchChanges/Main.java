package com.jdc.mkt.switchChanges;

public class Main {

	public static void main(String[] args) {

		String res = checkTypeOfA(null);
		System.out.println(res);
	}
	
	@SuppressWarnings("preview")
	static	String checkTypeOfA(Object obj) {
		return switch(obj) {
		case C a -> String.format("Values :%d", a);
		case B b -> String.format("Values :%f", b);
		case A c -> String.format("Values :%s", c);
		case null -> String.format("Values :%s", "null");
		default -> String.format("Values :%s", "no args");
		};
	}
	
	@SuppressWarnings("preview")
	static String checkString(String str) {
		return switch(str) {
		case null -> "OOps";
		case "A" -> "This is A";
		default -> "no value";
		};
	}
}

class A {
}

class B extends A {
}

class C extends A {
}
