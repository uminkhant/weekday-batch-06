package com.jdc.mkt.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/uploadImage")
@MultipartConfig
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/imageUpload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var part = req.getPart("imageUpload");
		if(null != part) {
			var path = Path.of(getServletContext().getRealPath("images"), part.getSubmittedFileName());
			Files.copy(part.getInputStream(), path);
		}
		
		req.setAttribute("image","images/"+part.getSubmittedFileName());
		System.out.println(req.getAttribute("image"));
		getServletContext().getRequestDispatcher("/imageUpload.jsp").forward(req, resp);
	}

}










