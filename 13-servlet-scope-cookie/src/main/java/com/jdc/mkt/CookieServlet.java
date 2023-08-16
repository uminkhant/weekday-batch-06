package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var cks = req.getCookies();
		
		for(Cookie c :cks) {
			System.out.println(c.getName()+"\t"+c.getValue());
		}
		
		req.getRequestDispatcher("cookie.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		System.out.println(name + "\t"+pass);
		
		Cookie ckName = new Cookie("cName", name);
		Cookie ckPass = new Cookie("cPass", pass);
		resp.addCookie(ckName);
		resp.addCookie(ckPass);
		resp.sendRedirect("/cookie.jsp");
	 
		
	}

}
