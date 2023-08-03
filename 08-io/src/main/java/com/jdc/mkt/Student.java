package com.jdc.mkt;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name ;
	private int age;
	private  Address address;

	//setValues with Constructor
	public Student(String name,int age,String street,
		String township,String city){
		this.name = name;
		this.age = age ;
		address = new Address(street,township,city);
	}
	//getValues for each fields;
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getStreet(){
		return address.getStreet();
	}
	public String getTownship(){
		return address.getTownship();
	}
	public String getCity(){
		return address.getCity();
	}

}