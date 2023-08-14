package com.jdc.mkt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello",
name = "helloServlet",
initParams = {
	@WebInitParam(name = "name",value = "Aung Aung"),
	@WebInitParam(name = "age",value = "23")
})
public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static String header = """
			
			<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
				</head>
				<body>	
				<h1>			
			""";
	private static String footer = """
				</h1>
				</body>
				</html>
			""" ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String message = req.getParameter("message");
	
		
		var params = getInitParameterNames();
		
		while(params.hasMoreElements()) {
			var param = params.nextElement();
			System.out.println("%s is %s ".formatted(param,getInitParameter(param)));
		}	
		System.out.println("--------------------");
			
		
		System.out.println(getServletConfig().getServletName());
		System.out.println(req.getContextPath());
		System.out.println(req.getProtocol());
		
		
		resp.getWriter()
		.append(header)
		.append(message)
		.append(footer)		
		.flush();
	}
	
	
	
}
