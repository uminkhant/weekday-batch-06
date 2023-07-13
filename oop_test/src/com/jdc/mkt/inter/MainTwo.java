package com.jdc.mkt.inter;

public class MainTwo {

	public static void main(String[] args) {
		
	}
}

class UsInter implements MyInter2,MyInter3 {

	@Override
	public void show() {
		MyInter3.super.show();
	}
	
}

interface MyInter1{
	
	default void show() {
		System.out.println("show from 1");
	}
}

interface MyInter2 extends MyInter1{
	
	@Override
	default void show() {
		System.out.println("show from 2");
	}
}

interface MyInter3 extends MyInter1{
	
	@Override
	default void show() {
		System.out.println("show from 3");
	}
}
