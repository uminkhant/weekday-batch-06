package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends Member{

	private static final long serialVersionUID = 1L;
	
	@Enumerated( EnumType.STRING)
	@Column(name = "customer_type")
	private CustomerType customerType;
		
	public Customer(String name, String loginId, String password) {
		super(name, loginId, password);
		setRole(Role.CUSTOMER);
	}
	
	public enum CustomerType {
		GOLD,SILVER,DIAMOND
	}

}
