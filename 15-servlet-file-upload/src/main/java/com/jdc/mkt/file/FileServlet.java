package com.jdc.mkt.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.jdc.mkt.file.Member.Role;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadFile")
@MultipartConfig
public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/fileUpload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("fileUpload");
		var list = new ArrayList<Member>();
		try(var br = new BufferedReader(
				new InputStreamReader(part.getInputStream()))){
			String str = "";
			
			while((str= br.readLine()) != null) {
				var array = str.split(":");
				var member = new Member(
					Integer.parseInt(array[0]),
					array[1],
					Role.valueOf(array[2]),
					array[3],
					array[4],
					array[5]);
				list.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().setAttribute("members", list);
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}







