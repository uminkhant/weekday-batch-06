package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NamedQuery;
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
		var em =emf.createEntityManager();
		
		var query = em.createNamedQuery("getAllCategory", Category.class);
		req.setAttribute("categories", query.getResultList());
		System.out.println("Size"+ query.getResultList().size());
		getServletContext().getRequestDispatcher("/category.jsp").forward(req, resp);
	}
}
