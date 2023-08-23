package com.jdc.mkt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/useJstl")
public class FormatServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date date = new Date();		
		LocalDate ld = LocalDate.now();
		
		req.setAttribute("date",date);
		req.setAttribute("localDate", ld);
		
		getServletContext().getRequestDispatcher("/useJstl.jsp").forward(req, resp);
	}

}
