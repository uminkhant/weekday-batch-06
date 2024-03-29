package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/admin/addCategory","/admin/category","/admin/deleteCategory"})
public class CategoryServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		var em = createEntityManager();
		
		if(req.getServletPath().equals("/admin/deleteCategory")) {
			var id = Integer.parseInt( req.getParameter("id"));
			Category cat = em.find(Category.class, id);
			em.getTransaction().begin();
			cat.setDeleted(true);
			em.merge(cat);
			em.getTransaction().commit();
		}
		var query = em.createNamedQuery("getAllCategory", Category.class);
		getServletContext().setAttribute("categories", query.getResultList());
		closeEntityManager();
		getServletContext().getRequestDispatcher("/admin/category.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("category");
		var em = createEntityManager();	
		em.getTransaction().begin();
		em.persist( new Category(name));
		em.getTransaction().commit();
		closeEntityManager();
		resp.sendRedirect("/admin/category");
	}
}
