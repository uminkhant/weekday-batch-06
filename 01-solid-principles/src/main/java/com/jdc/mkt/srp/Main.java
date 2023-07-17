package com.jdc.mkt.srp;

public class Main {
	
	public static void main(String[] args) {
		Student st = new Student();
		st.doRegister();
		Teacher t = new Teacher();
		t.doRegister();
	}
}

class Teacher{
	void doRegister(){
		Register r = new Register();
		r.greeting();
		r.addData();
		r.operation();
		r.saveToDb();
	}
}

class Student{
	void doRegister(){
		Register r = new Register();
		r.greeting();
		r.addData();
		r.operation();
		r.saveToDb();
	}
}

class Register{
	
	void greeting() {}
	void addData() {}
	void operation() {}
	void saveToDb() {}
	void payment() {}
	void salary() {}
}