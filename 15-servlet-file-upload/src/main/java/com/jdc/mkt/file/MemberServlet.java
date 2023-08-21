package com.jdc.mkt.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Member.Role;
import com.jdc.mkt.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member")
@MultipartConfig
public class MemberServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private MemberService service;
	
	@Override
	public void init() throws ServletException {
		service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/member.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String email = req.getParameter("email");
		String image = getImage(req);
		var member = new Member(0,name,Role.valueOf(role),loginId,password,email,image);
		service.saveMember(member);
		//getServletContext().getRequestDispatcher("/member.jsp").forward(req, resp);
		resp.sendRedirect("/member.jsp");
	}

	private String getImage(HttpServletRequest req) throws IOException, ServletException {
		var part = req.getPart("image");
		if(null != part) {
			var path = Path.of(getServletContext().getRealPath("images"), part.getSubmittedFileName());
			Files.copy(part.getInputStream(), path);
		}
		return part.getSubmittedFileName();
	}
}





