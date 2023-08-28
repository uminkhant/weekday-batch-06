package com.jdc.mkt.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet({"/admin/addProduct","/admin/showProduct"})
@MultipartConfig
public class ProductServlet extends FactoryServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		var em = createEntityManager();
		var qProdcut = em.createNamedQuery("getAllProduct",Product.class);
		var qCat =em.createNamedQuery("getAllCategory",Category.class);
		getServletContext().setAttribute("categories", qCat.getResultList());
		getServletContext().setAttribute("products", qProdcut.getResultList());
		getServletContext().getRequestDispatcher( req.getServletPath().concat(".jsp")).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		var name = req.getParameter("name");
		var cat_id = Integer.parseInt( req.getParameter("category"));
		var dtPrice =  Integer.parseInt(req.getParameter("dtPrice"));
		var wsPrice =  Integer.parseInt(req.getParameter("wsPrice"));
		var desc = req.getParameter("desc");
		var image = getImageName(req);
		var em = createEntityManager();
		var category = em.find(Category.class, cat_id);
		var product = new Product(name, dtPrice, wsPrice, desc, image, category);
		
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		closeEntityManager();
		resp.sendRedirect("/admin/showProduct");
		
	}

	private String getImageName(HttpServletRequest req) {
		Part part = null;
		 try {
			 part = req.getPart("image");
			var path = Path.of(getServletContext().getRealPath("images"), part.getSubmittedFileName());
			Files.copy(part.getInputStream(),path);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}		
		return part.getSubmittedFileName();
	}
}
