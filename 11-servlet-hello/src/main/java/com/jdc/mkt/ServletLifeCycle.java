package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = "/cycle",name = "cycle",loadOnStartup = 1)
public class ServletLifeCycle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		log("--------------------- >>>>> > init method start");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("--------------------- >>>>> > get method start");
		resp.getWriter().append("Servle Life Cycle");
		
	}
	
	@Override
	public void destroy() {
		log("--------------------- >>>>> > destroy method start");
	}

}
