package com.jdc.mkt.anno;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings({ "serial" })
public class AnnotationDemo implements Serializable {

	@MyAnno(value = "Wanna",status = STATUS.MALE)
	String name;

	@MyAnno(value = "Aung Aung", age = 22,status = STATUS.MALE)
	void show() {
	}

	public void useMethodWithMyAnno() throws NoSuchMethodException, SecurityException {
		Method m = AnnotationDemo.class.getDeclaredMethod("show");
		MyAnno ano = m.getDeclaredAnnotation(MyAnno.class);

		if (null != ano) {
			System.out.println("Name :" + ano.value() + "\tAge :" + ano.age());
		}

	}

	public void useFiledWithMyAnno() throws NoSuchFieldException, SecurityException {
		Field f = AnnotationDemo.class.getDeclaredField("name");
		MyAnno ano = f.getDeclaredAnnotation(MyAnno.class);

		if (null != ano) {
			System.out.println("Name :" + ano.value() + "\tAge :" + ano.age());
			System.out.println(ano.status());
			
		}
	}
	
	public  void useDefault() {
		DefaultAnno d = new DefaultAnno();
		d.show();
		d.setStrings("ss","aa");
	}

}

@SuppressWarnings("serial")
class DefaultAnno implements Serializable{
	
	String name;
	
	
	@Deprecated
	void show() {
		System.out.println("Deprecated");
	}
	
	@SuppressWarnings("unused")
	void setStrings(String ...str) {
		for(String s :str) {
			//System.out.println(s);
		}
	}
}

enum STATUS{
	MALE,FEMALE
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
@interface MyAnno {
	String[] value();

	int age() default 18;
	STATUS status();
	
}
