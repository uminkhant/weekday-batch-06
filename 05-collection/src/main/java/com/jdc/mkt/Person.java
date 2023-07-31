package com.jdc.mkt;

import java.util.Objects;

public class Person extends Object implements Comparable<Person>{

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
		return this.name.compareTo(p.name);
		//return this.age > p.age?1:-1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	
	
	
}

class Human{
}
