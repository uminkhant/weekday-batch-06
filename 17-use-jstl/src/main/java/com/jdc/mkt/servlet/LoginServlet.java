package com.jdc.mkt.servlet;

import java.io.IOException;
import java.util.List;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		var em = createEntityManager();
		var query = em.createQuery("select m from Member m where m.loginId = :loginId");
		query.setParameter("loginId", loginId);
		var members =(List<Member>) query.getResultList();
		
		if(null != members) {
			if(members.get(0).getPassword().equals(password)) {
				getServletContext().setAttribute("member", members.get(0));
				getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
			}else {
				getServletContext().getRequestDispatcher("/login").forward(req, resp);
			}
		}
	}

}
