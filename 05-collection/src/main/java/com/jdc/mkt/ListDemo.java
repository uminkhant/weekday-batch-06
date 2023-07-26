package com.jdc.mkt;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	
	public static void main(String[] args) {
		
		List<Integer> array = getListObj("array");
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		long l1 =  getMillis(array,"add");
		System.out.println("Time For Array List : "+l1);
		
	
		List<Integer> link = getListObj("link");
		long l2 =  getMillis(link,"add");
		System.out.println("Time For Link List : "+l2);
		
		long l3 =  getMillis(array,"s");
		System.out.println("Time For Array List : "+l3);
		
		long l4 =  getMillis(link,"s");
		System.out.println("Time For Link List : "+l4);
		
	}
	
	
	
	static Long getMillis(List<Integer> list,String ope) {
		var l1 = LocalDateTime.now();
		for(int i = 0 ; i < 200000; i++) {
			if(ope.equals("add")) {
				list.add(i);
			}else {
				list.remove(0);
				//list.set(i, list.get(i)+1);
			}	
			
		}
		var l2 = LocalDateTime.now();
		return l1.until(l2, ChronoUnit.MILLIS);
	}
	
	static List<Integer> getListObj(String list){
		return list.equalsIgnoreCase("array")?
				new ArrayList<Integer>():new LinkedList<Integer>();
	}
}










