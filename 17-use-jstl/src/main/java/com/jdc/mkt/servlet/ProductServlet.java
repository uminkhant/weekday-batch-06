package com.jdc.mkt.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/addProduct","/showProduct"})
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var localDate = LocalDate.now();
		req.setAttribute("ld", localDate);
		getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
	}
}
