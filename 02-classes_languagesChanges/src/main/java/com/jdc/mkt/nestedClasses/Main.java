package com.jdc.mkt.nestedClasses;

import com.jdc.mkt.nestedClasses.SuperClass.StaticSub;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SuperClass su = new SuperClass();
		//InnerClass inner = su. new InnerClass();
		
		StaticSub sub = new SuperClass.StaticSub();
	}
}


