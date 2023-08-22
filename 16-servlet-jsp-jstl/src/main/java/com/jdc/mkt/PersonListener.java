package com.jdc.mkt;

import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class PersonListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		var list = List.of(
				new Person("William",30),
				new Person("John",22),
				new Person("Susan",25),
				new Person("Arnel Musa",33),
				new Person("Upul Sampah",22)
				);
		
		sce.getServletContext().setAttribute("persons", list);
	}
	
	
}
