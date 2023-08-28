package com.jdc.mkt.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends Member{

	private static final long serialVersionUID = 1L;

	public Admin(String name, String loginId, String password, String street, String township, String city) {
		super(name, loginId, password, street, township, city);
		setRole(Role.ADMIN);
	}
		
	



	

}
