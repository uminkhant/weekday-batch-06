package com.jdc.mkt.encapsulation;

public class PersonImpl implements Person {
	
	public String name;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
