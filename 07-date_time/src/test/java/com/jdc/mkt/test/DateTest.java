package com.jdc.mkt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

public class DateTest {

	//@Test
	void test1() throws ParseException {
		Date d = new Date();	
		System.out.println(d);
		
		Date d2 = Calendar.getInstance().getTime();
		System.out.println(d2);
		
		DateFormat df = new SimpleDateFormat("MM.dd.yyyy");
		Date d3 = df.parse("22.12.1999");		
		System.out.println(d3);
		
	}
	
	//@Test
	void testDate() {
		Date d = new Date();
	
//		System.out.println(d.getDate());
//		d.setDate(20);
//		d.setMonth(02);
//		d.setYear(2000);
		System.out.println(d);
	}
	
	//@Test
	void testCalendar() {
		Calendar cl = Calendar.getInstance();
		
		//cl.setLenient(false);
		//cl.set(2011, 1, 30);
		//cl.set(Calendar.DAY_OF_YEAR,3);
		//cl.setLenient(false);
		//cl.set(Calendar.DAY_OF_WEEK,7);
		cl.add(Calendar.DAY_OF_MONTH, 32);
		cl.roll(Calendar.DAY_OF_MONTH, 32);
		System.out.println(cl.getTime());
		
	}
	
	@Test
	void testDateFormat() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy 'at' HH:mm:ss");
		Date d = df.parse("20_02_1800 at 08:20:30");
		System.out.println(d);
	}
	
	
	
}




