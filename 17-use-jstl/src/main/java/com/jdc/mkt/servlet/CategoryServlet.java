package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/category","/addCategory"})
public class CategoryServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		var em = createEntityManager();
		var query = em.createNamedQuery("getAllCategory", Category.class);
		req.setAttribute("categories", query.getResultList());
		closeEntityManager();
		getServletContext().getRequestDispatcher("/category.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("category");
		var em = createEntityManager();	
		em.getTransaction().begin();
		em.persist( new Category(name));
		em.getTransaction().commit();
		closeEntityManager();
		resp.sendRedirect("/category");
	}
}
