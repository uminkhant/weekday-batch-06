package com.jdc.mkt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private int id;
	private String name;
	private Role role;
	private String loginId;
	private String password;
	private String email;
	private String image;
	
	
	public enum Role{
		ADMIN,USER
	}
}
