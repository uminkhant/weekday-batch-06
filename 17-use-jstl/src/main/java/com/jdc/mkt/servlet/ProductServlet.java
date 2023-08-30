package com.jdc.mkt.servlet;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
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

@WebServlet({ "/admin/addProduct", "/admin/showProduct", "/admin/editProduct" ,"/detailProduct"})
@MultipartConfig
public class ProductServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var em = createEntityManager();
		var qProdcut = em.createNamedQuery("getAllProduct", Product.class);
		var qCat = em.createNamedQuery("getAllCategory", Category.class);
		getServletContext().setAttribute("categories", qCat.getResultList());
		getServletContext().setAttribute("products", qProdcut.getResultList());

		switch (req.getServletPath()) {
		case "/admin/addProduct":
		case "/admin/showProduct":
			getServletContext().getRequestDispatcher(req.getServletPath().concat(".jsp")).forward(req, resp);
			break;
		case "/detailProduct":
			var product = em.find(Product.class, Integer.parseInt(req.getParameter("id")));
			req.setAttribute("product", product);
			getServletContext().getRequestDispatcher("/detailProduct.jsp").forward(req, resp);
			break;
		case "/admin/editProduct":
			var id = Integer.parseInt(req.getParameter("id"));
			Product p = em.find(Product.class, id);
			req.setAttribute("product", p);
			getServletContext().getRequestDispatcher("/admin/addProduct").forward(req, resp);
			break;

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var idP = req.getParameter("id");
		var name = req.getParameter("name");
		var cat_id = Integer.parseInt(req.getParameter("category"));
		var dtPrice = Integer.parseInt(req.getParameter("dtPrice"));
		var desc = req.getParameter("desc");
		var image = getImageName(req);
		var em = createEntityManager();
		var category = em.find(Category.class, cat_id);

		Product product = null;
		if (null != idP && !idP.isEmpty()) {
			var id = Integer.parseInt(idP);
			product = em.find(Product.class, id);
			product.setId(id);
			product.setName(name);
			product.setDetailPrice(dtPrice);
			product.setCategory(category);
			product.setImage(null != image ? image : product.getImage());
			product.setDescription(desc);
		} else {
			image = null != image ? image : "noImage.png";
			product = new Product(name, dtPrice, desc, image, category);

		}

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

			if (null != part && (null != part.getSubmittedFileName() && !part.getSubmittedFileName().isEmpty())) {
				var path = Path.of(getServletContext().getRealPath("images"), part.getSubmittedFileName());
				Files.copy(part.getInputStream(), path);
				return part.getSubmittedFileName();
			}
		} catch (FileAlreadyExistsException e) {
			return part.getSubmittedFileName();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return null;

	}
}
