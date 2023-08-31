package com.jdc.mkt.entity;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorColumn(name = "member_type")
@NamedQuery(name = "getAllMembers",query = "select m from Member m ")
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
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Address address;
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Contact contact;
	
	public Member(String name, String loginId, String password) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		
	}
	
	public void addAddress(Address address) {
		address.setMember(this);
		this.address = address;
	}
	public void addContact(Contact contact) {
		contact.setMember(this);
		this.contact = contact;
	}


	public enum Role{
		ADMIN,CUSTOMER
	}
}
