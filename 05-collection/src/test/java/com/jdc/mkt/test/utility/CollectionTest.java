package com.jdc.mkt.test.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionTest {

	List<String> list = new ArrayList<String>();
	
	void addDatas() {
		list.add("BB");
		list.add("aa");
		list.add("SS");
		list.add("aa");
		list.add("gg");
		list.add("HH");
	}
	
	//@Test
	@DisplayName("1.Sort,shuffle collection")
	void test1() {
		addDatas();
		System.out.println("Before Sort : "+list);
		Collections.sort(list);
		System.out.println("After Sort : "+list);
		Collections.shuffle(list);
		System.out.println("Shuffle : "+list);
		Collections.sort(list);
		var res = Collections.binarySearch(list, "gg");
		assertEquals(5, res);
		int count = Collections.frequency(list, "aa");
		assertEquals(2, count);
		List<String> list1 = List.of("aa","xx","ll","mm");
		var joint = Collections.disjoint(list, list1);
		assertFalse(joint);
		
	}
	@Test
	@DisplayName("2.unmodified")
	void test2() {
		List<String> list1 =  Collections.unmodifiableList(list);
		
		assertThrows(UnsupportedOperationException.class,()->{
			list1.add("other");
			list1.remove(0);
		});
	}
}
