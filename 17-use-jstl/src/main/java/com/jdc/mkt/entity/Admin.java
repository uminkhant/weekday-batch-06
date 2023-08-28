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
		
	public Admin(String name, String loginId, String password) {
		super(name, loginId, password);
		setRole(Role.ADMIN);
	}



	

}
