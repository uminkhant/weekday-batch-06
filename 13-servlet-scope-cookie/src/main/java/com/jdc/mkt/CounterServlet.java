package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/counterServlet")
public class CounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String COUNTER = "counter";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Counter c1 = (Counter) req.getAttribute(COUNTER);
		
		if(null == c1 ) {
			c1 = new Counter();	
			req.setAttribute(COUNTER, c1);
		}
		c1.countUp();
		
		HttpSession session = req.getSession();
		Counter c2 = (Counter) session.getAttribute(COUNTER);
		
		if(null == c2) {
			c2 = new Counter();
			session.setAttribute(COUNTER, c2);
		}
		c2.countUp();
		
		ServletContext context = getServletContext();
		Counter c3 = (Counter) context.getAttribute(COUNTER);
		
		if(null == c3) {
			c3 = new Counter();
			context.setAttribute(COUNTER, c3);
		}
		c3.countUp();
		
		context.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	
}








