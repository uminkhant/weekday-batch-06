package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false ,unique = true, length = 12)
	private String primaryPhone;
	@Column(unique = true, length = 12)
	private String secondaryPhone;

	@OneToOne(mappedBy = "contact")
	private Member member;

	public Contact(String primaryPhone, String secondaryPhone) {
		super();
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
	}
	
	
	
	
}
