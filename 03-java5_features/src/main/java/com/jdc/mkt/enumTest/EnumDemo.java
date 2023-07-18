package com.jdc.mkt.enumTest;

public class EnumDemo {

	public void useConstant() {
		Day d = Day.THUR;
		d.showFullName();
		System.out.println(d.getName());

//		//use interface
//		int x = DayS.WED;
//		System.out.println("Constant From Interface :"+x);
//		
//		//use enum
//		int y = Day.WED.ordinal();
//		System.out.println("Index From Enum :"+y);
//		
//		
//		System.out.println("Enum Constant Name :"+d);
//		
//		//check with using equality operator
//		System.out.println("Is Equal :"+(d == Day.MON));
//		
//		//default method
//		System.out.println("Constant name :%s index :%d "
//				.formatted(d.name(),d.ordinal()));

	}

	public void showConstants() {
		for (Day d : Day.values()) {
			System.out.println("Name :%s index :%d".formatted(d.name(), d.ordinal()));
		}
	}
	
	public void usingSwitch(Day day) {
		switch(day) {
		case MON:
		case TUE:
		case WED:
		case THUR:
		case FRI:
			System.out.println("Work Day");
			break;
		case SAT:
		case SUN:
			System.out.println("Off Day");
			break;
		}
	}
}



//BEFORE ENUM
interface DayS {
	static final int MON = 1, TUE = 2, WED = 3, THUR = 4, FRI = 5, SAT = 6, SUN = 7;
}


