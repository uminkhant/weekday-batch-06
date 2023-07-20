package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.anno.AnnotationDemo;

public class AnnoTest {

	@Test
	void test1() throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		AnnotationDemo demo = new AnnotationDemo();
		demo.useMethodWithMyAnno();
		demo.useFiledWithMyAnno();
	}
}
