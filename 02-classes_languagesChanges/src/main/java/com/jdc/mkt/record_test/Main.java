package com.jdc.mkt.record_test;

public class Main {

	public static void main(String[] args) {

		useInter(new Student("mem", 12));

	}

	static void useInter(MyInter inter) {
		if (inter instanceof Student s) {
			Student st = (Student) inter;
			
			System.out.println("Name :%s age :%d".formatted(st.name(), st.age()));
		}else if(inter instanceof Member m) {
			System.out.println("Name :%s age :%d".formatted(m.name(), m.age()));
		}
	}
}

interface MyInter {
}

record Student(String name, int age) implements MyInter {
}

record Member(String name, int age) implements MyInter {

//	
//	public Member(String name) {
//		this(name,0);
//		
//	}
//	
//	public String name() {
//		System.out.println("Name ");
//		return name;
//	}
//	
//	static void doSometing() {}

}
