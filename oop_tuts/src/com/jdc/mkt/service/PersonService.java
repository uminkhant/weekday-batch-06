package com.jdc.mkt.service;

import com.jdc.mkt.entity.Person;

public interface PersonService {

	void insert(Person p);
	Person findById(int id);
}
