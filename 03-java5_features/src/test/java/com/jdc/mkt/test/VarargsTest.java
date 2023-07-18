package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.varargsTest.VarargsDemo;

public class VarargsTest {

	@Test
	void test1() {
		VarargsDemo demo = new VarargsDemo();
		//String[] names = {"Aung Aung","Sandar","Thidar"};
		demo.showNames("Aung Aung","Sandar","Thidar");
	}
}
