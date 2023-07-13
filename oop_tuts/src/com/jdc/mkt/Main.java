package com.jdc.mkt;

import com.jdc.mkt.entity.Person;
import com.jdc.mkt.service.PersonService;
import com.jdc.mkt.service.PersonServiceImpl;

public class Main {

	public static void main(String[] args) {
		PersonService service = new PersonServiceImpl();
		service.insert(new Person());
		service.findById(1);
		//service.doSomething();
		
	}
}
