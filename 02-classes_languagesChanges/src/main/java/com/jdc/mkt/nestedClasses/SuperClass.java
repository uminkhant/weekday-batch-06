package com.jdc.mkt.nestedClasses;

@SuppressWarnings("unused")
public class SuperClass {

	private String name;
	private static String staticName;

	void useInnerSub() {
		InnerClass inner = new InnerClass();
		inner.setName("ss");
	}

	void useName() {
		final int age = 0;
		class LocalClass {
			void showName() {
				System.out.println(age);
			}
		}
		
	}

	private class InnerClass {
		void setName(String name) {
			SuperClass su = new SuperClass();
			su.name = name;
		}
	}

	static class StaticSub {
		void setStaticName(String staticName) {
			SuperClass.staticName = staticName;
		}
	}
}
