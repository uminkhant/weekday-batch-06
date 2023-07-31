package com.jdc.mkt.test.utility;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayTest {

	String array[] = {"William","John","Arnel","Samlew","J.Smith"};
	
	//@Test
	@DisplayName("1.sorting")
	void test1() {
		showData("Before sort");
		Arrays.sort(array,Comparator.naturalOrder());
		showData("After sort");
	}
	//@Test
	@DisplayName("2.binarySearch")
	void test2() {
		Arrays.sort(array,Comparator.reverseOrder());
		showData("After sort");
		var res = Arrays.binarySearch(array, "John");
		System.out.println(res);
		//assertEquals(2, res);
	}
	
	//@Test
	@DisplayName("3.fill ,equal , copyof")
	void test3() {
		Arrays.fill(array,1,2, "NoName");
		showData("Fille");
		String []str1 = {"William","John","Arnel","Samlew","J.Smith"};
		var res = Arrays.equals(str1, array);
		assertFalse(res);
			
	}
	
	@Test
	@DisplayName("4. unlimitted size array")
	void test4() {
		for(int i = 0 ; i < 5 ; i++ )
			addData("NewString");
		
		showData("After add data");
	}
	
	void addData(String value) {
		array = Arrays.copyOf(array, array.length+1);
		array[array.length-1] = value;
		
	}
	
	void showData(String message) {
		System.out.println(message);
		System.out.print("[");
		for(int i = 0 ;i <array.length ; ) {
			System.out.print(array[i]);
			i++;
			if(i < array.length) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	 
}
