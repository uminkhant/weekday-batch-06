package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		emf = Persistence.createEntityManagerFactory("use-jstl");
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var cat = new Category(0,"Foods");
		em.persist(cat);
		
		em.getTransaction().commit();
		
		
		getServletContext().getRequestDispatcher("/category.jsp").forward(req, resp);
	}
}
