package com.jdc.mkt;

public class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return getName()+"\t"+getAge();
	}

	@Override
	public int compareTo(Person p) {
		//return this.name.compareTo(p.name);
		return this.age > p.age?1:-1;
	}
}
