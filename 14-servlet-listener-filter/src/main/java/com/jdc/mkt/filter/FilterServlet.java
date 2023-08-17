package com.jdc.mkt.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/filter/*")
public class FilterServlet implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var path = request.getParameter("name");
		 var context = request.getServletContext();
		if (path.equals("home")) {
			chain.doFilter(request, response);
		} else {
			context.getRequestDispatcher("/error.jsp").forward(request, response);
			System.out.println("After filter");
		}
	}

}
