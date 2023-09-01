package com.jdc.mkt.listener_filter;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

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
		emf = Persistence.createEntityManagerFactory("product-sale");
		sce.getServletContext().setAttribute("emf", emf);
		
		var em = emf.createEntityManager();	
		var qCategory = em.createNamedQuery("getAllCategory", Category.class);
		
		sce.getServletContext().setAttribute("categories",qCategory.getResultList());
		
		var qProduct = em.createNamedQuery("getAllProduct",Product.class);
		sce.getServletContext().setAttribute("products", qProduct.getResultList());
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
