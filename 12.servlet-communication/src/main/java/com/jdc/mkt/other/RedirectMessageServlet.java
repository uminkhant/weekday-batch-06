package com.jdc.mkt.other;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/other/redirect-message")
public class RedirectMessageServlet extends HttpServlet{

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
					<a href = "../index.html">Go To Home Page </a>
				</body>
			</html>
			""";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().append(header)
		.append("<p>Redirect message from redirect servlet </p>")
		.append(footer);
	}
	
}
