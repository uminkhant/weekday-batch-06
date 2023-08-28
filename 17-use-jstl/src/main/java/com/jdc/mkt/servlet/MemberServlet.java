package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Member.Role;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/admin/addMember","/admin/showMember"})
public class MemberServlet extends FactoryServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var em = createEntityManager();
		var query = em.createNamedQuery("getAllMembers", Member.class);
		
		req.setAttribute("memberRole", Role.values());
		req.setAttribute("members", query.getResultList());
		
		getServletContext().getRequestDispatcher(req.getServletPath().concat(".jsp")).forward(req, resp);
	}

}
