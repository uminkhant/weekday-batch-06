package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/include")
@SuppressWarnings("unused")
public class IncludeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String header = """
			<!DOCTYPE html>
				<html>
				<head>
					<meta charset="UTF-8">
					<title>Welcome</title>
				</head>
				<body>
			""";
	private static final String footer = """
					<a href = "index.html">Go To Home Page </a>
				</body>
			</html>
			""";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		var dispatcher  = req.getRequestDispatcher("other/message");
//			dispatcher.include(req, resp);
		var dispatcher = getServletContext().getNamedDispatcher("message");
		dispatcher.include(req, resp);
		resp.getWriter().append(header)
		.append("<p>INCLUDE</p>")
		.append(footer);
		System.out.println("Include .....");

	}
}
