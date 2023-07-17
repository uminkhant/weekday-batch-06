package com.jdc.mkt.dip;

public class Main {

	public static void main(String[] args) {
		
		//high
		Animal l = new Lion();
		l.sleep();
		
	}
}

interface Animal{
	void sleep();
}

class Lion implements Animal{
	
	

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}
}
