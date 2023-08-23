package com.jdc.mkt.listener;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener{

	private EntityManagerFactory emf;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		emf = Persistence.createEntityManagerFactory("use-jstl");
		sce.getServletContext().setAttribute("emf", emf);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("-----------------------Context Destroyed--------------");
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
