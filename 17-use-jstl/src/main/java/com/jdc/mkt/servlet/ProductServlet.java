package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/addProduct","/showProduct"})
public class ProductServlet extends FactoryServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		var em = createEntityManager();
		var query = em.createNamedQuery("getAllProduct",Product.class);
		req.setAttribute("products", query.getResultList());	
		getServletContext().getRequestDispatcher("/showProduct.jsp").forward(req, resp);
	}
}
