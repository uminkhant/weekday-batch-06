package com.jdc.mkt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	private static Student student;
	private static StudentService service;
	private static BufferedReader br;

	public static void main(String[] args) throws IOException {
	
		service = new StudentService();
		br = new BufferedReader(new InputStreamReader(System.in));
		Main m = new Main();
		m.greeting("Welcome To Student Registration Project");
		m.setStudent();
		m.greeting("Bye Bye");	
		
	}


	String getInput(){
		try{
			return br.readLine();

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}

	void setStudent(){
		String str = "";
		do{
			setData();
			System.out.println("Do you want to add again y/other");
			 str = getInput();
		}while("y".equalsIgnoreCase(str));
		service.writeToFile();
		showStudent();
	}

	void showStudent(){
		for (Student s :service.getStudents() ) {
			showData(s);
		}
	}

	void greeting(String message){
		System.out.println("------------------------------------------------------------------");
		System.out.println("   ===========  "+message+"    ============    ");
		System.out.println("------------------------------------------------------------------");
	}

	void setData(){
		System.out.println("Please type name !");
		String name = getInput();
		System.out.println("Please type age !");
		int age = Integer.parseInt(getInput());
		System.out.println("Please type St'street");
		String street = getInput();
		System.out.println("Please type St'township");
		String township = getInput();
		System.out.println("Please type St'city");
		String city = getInput();
		
		
		student = new Student(name,age,street,township,city);
		service.addStudent(student);
	}
	void showData(Student student){	
		System.out.println();
		System.out.print("Name : "+student.getName());
		System.out.print(" Age : "+student.getAge());
		System.out.print(" Street : "+student.getStreet());
		System.out.print(" Township : "+student.getTownship());
		System.out.print(" Citye : "+student.getCity());
		System.out.println();
	}
}