package com.jdc.mkt.varargsTest;

public class VarargsDemo {
	
	public void showNames(String...names) {
		for(String s:names) {
			System.out.println(s);
		}
	}
}
