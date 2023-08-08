package com.jdc.mkt;

public class LambdaDemo {

	public static void main(String[] args) {
		
		 String name  = "John";
		//before lambda
		MyData data = new MyData() {			
			@Override
			public void show(String s) {
				System.out.println("Hello lambda "+name);
			}
		};
		data.show("test");
		//name = "william";
		
		//after lambda
		MyData data1 =  s -> System.out.println("Hello "+s);	
		data1.show("William");
		
		MyData2 data2 = ( a, b) ->  a+10;
		int i = data2.plus(2, "ss");
		System.out.println(i);		
		
		MyData3 data3 = () -> new Person(1,"John");
		var  p = data3.usePerson();
		System.out.println(p.getId() +"\t"+ p.getName());
	}
}

interface MyData3{
	
	String name = "John";
	Person usePerson();
	static void show() {
		System.out.println("Hello java");
	}
}

interface MyData2{
	int plus(int a,String b);
	

}

interface MyData{	
	void show(String s);
}

class Person{
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
		public String getName() {
		return name;
	}
	
}






