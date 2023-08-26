package com.jdc.mkt.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.SaleDetails;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/addToCart", "/detailsCart","/clearCart" })
public class CartServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;
	private List<SaleDetails> list;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case "/addToCart":
			list = new ArrayList<SaleDetails>();
			var session = req.getSession(true);

			if (session.getAttribute("saleDetails") != null) {
				list = (List<SaleDetails>) session.getAttribute("saleDetails");
			}
			int id = Integer.parseInt(req.getParameter("id"));
			Product product = createEntityManager().find(Product.class, id);
			var sd = new SaleDetails(1, product);
			
			list.add(sd);
					
			session.setAttribute("saleDetails", list);
			resp.sendRedirect("/index.jsp");
			break;
		case"/clearCart":
			if(null != list && !list.isEmpty()) {
				list.clear();
			}
			resp.sendRedirect("/index.jsp");
			break;
		case "/detailsCart":
			resp.sendRedirect("/voucher.jsp");
			break;
		}

	}

}
