package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Member.Role;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/addMember","showMember"})
public class MemberServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("memberRole", Role.values());
		getServletContext().getRequestDispatcher("/addMember.jsp").forward(req, resp);
	}

}
