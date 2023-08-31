package com.jdc.mkt.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Sale;
import com.jdc.mkt.entity.SaleDetails;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/admin/saleHistory","/sale"})
@SuppressWarnings("unchecked")
public class SaleServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var em = createEntityManager();
		var query = em.createNamedQuery("getAllSaleDetails", SaleDetails.class);
		req.setAttribute("saleHistory", query.getResultList());
		closeEntityManager();
		getServletContext().getRequestDispatcher(req.getServletPath().concat(".jsp")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<SaleDetails> list = (List<SaleDetails>) req.getSession().getAttribute("saleDetails");
		var em = createEntityManager();
		Member member = (Member) getServletContext().getAttribute("member");
		int total = list.stream().mapToInt(sd -> sd.getQty() * sd.getProduct().getDetailPrice()).sum();
		var sale = new Sale(member, LocalDate.now(), LocalTime.now(), total);
		
		
		for (SaleDetails d : list) {
			sale.addSaleDetail(d);
		}
		if (null != member) {
			em.getTransaction().begin();
			em.persist(sale);
			em.getTransaction().commit();
			closeEntityManager();
			req.getSession().setAttribute("saleDetails", null);
			resp.sendRedirect("/index.jsp");
		}else {
			req.setAttribute("message", "Please LoginId first before you paid !");
			getServletContext().getRequestDispatcher("/detailsCart.jsp").forward(req, resp);
		}
		

	}
}
