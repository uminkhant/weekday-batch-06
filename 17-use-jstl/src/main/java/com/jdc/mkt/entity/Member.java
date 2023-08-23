package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "varchar(40) not null default 'NO NAME'")
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(nullable = false,unique = true)
	private String loginId;
	private String password;
	@ManyToOne
	private Address address;
	@OneToMany(mappedBy = "member")
	private List<Contact> contacts;
	
	
	
	public enum Role{
		AMDIN,CUSTOMER
	}
}
