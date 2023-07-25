package com.jdc.mkt;

public class ExceptionDemo {

	private String password = "admin";
	private Member member;

	public Member validate(String name, String pass, int age) {
		try {
			if (null == name || name.isEmpty()) {
				throw new MyException("There is no name !");
			}

			if (!pass.equals(password)) {
				throw new MyException("Please type again !");
			}
			if (age >= 18) {
				member = new Member();
				member.setName(name);
				member.setPass(pass);
				return member;
			}

		} catch (MyException e) {
			throw new RuntimeException(e.getMessage());
		}
		return null;
	}
	
	public Member other(Member m) {
		return m;
	}

}
