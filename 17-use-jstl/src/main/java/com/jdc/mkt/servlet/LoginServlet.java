package com.jdc.mkt.servlet;

import java.io.IOException;
import java.util.List;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/signIn", "/logout" })
public class LoginServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getServletPath().equals("/logout")) {
			getServletContext().setAttribute("member", null);
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		var em = createEntityManager();
		var query = em.createQuery("select m from Member m where m.loginId = :loginId");
		query.setParameter("loginId", loginId);
		var members = (List<Member>) query.getResultList();

		if (null != members) {
			var member = members.get(0);
			if (member.getPassword().equals(password)) {
				getServletContext().setAttribute("member", member);

			}else {
				req.setAttribute("message", "Something wrong and try again !");
				
			}
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

		}
	}

}
