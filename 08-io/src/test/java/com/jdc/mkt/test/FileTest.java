package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	void test1() throws IOException, URISyntaxException {
		File dir = new File("/Users/minkhantthu/JDC WORKSPACE/eclipse/batch-06-weekday/08-io/src/main/resources/parent");	
		File f = new File(dir,"Test.txt");
		
		if(f.exists()) {
			f.delete();
		}		
		System.out.println("Absolute Path :"+f.getAbsolutePath());
		System.out.println("Name : "+f.getName());
		System.out.println("Parent : "+f.getParent());
		System.out.println("Length : "+f.length());
		
		assertFalse(f.exists());	
		
		f.createNewFile();	
		
		assertFalse(f.isHidden());
		assertTrue(f.exists());
		assertTrue(f.isAbsolute());
	}
}
