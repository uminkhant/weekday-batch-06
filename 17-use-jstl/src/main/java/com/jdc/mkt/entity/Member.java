package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorColumn(name = "member_type")
@NamedQuery(name = "getAllMembers",query = "select m from Member m join m.contacts")
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
	private List<Contact> contacts = new ArrayList<Contact>();
	
	public Member(String name, String loginId, String password) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		
	}
	public void addContact(Contact contact) {
		contact.setMember(this);
		this.contacts.add(contact);
	}


	public enum Role{
		ADMIN,CUSTOMER
	}
}
