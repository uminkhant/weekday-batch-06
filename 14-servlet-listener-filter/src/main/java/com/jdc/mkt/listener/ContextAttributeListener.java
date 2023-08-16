package com.jdc.mkt.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		
		System.out.println("Attribute Added");
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Attribute replaced");
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Attribute removed");
	}
}
