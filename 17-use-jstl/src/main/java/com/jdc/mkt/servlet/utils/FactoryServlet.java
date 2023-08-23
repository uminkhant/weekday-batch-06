package com.jdc.mkt.servlet.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.http.HttpServlet;

public class FactoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public EntityManager createEntityManager() {
		var emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
		em = emf.createEntityManager();
		return em ;
	}
	
	public void closeEntityManager() {
		if(null != em && em.isOpen()) {
			em.close();
		}
	}

}
