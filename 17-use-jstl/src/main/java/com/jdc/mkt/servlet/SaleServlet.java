package com.jdc.mkt.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

@WebServlet("/sale")
public class SaleServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<SaleDetails> list = (List<SaleDetails>) req.getSession().getAttribute("saleDetails");
		var em = createEntityManager();
		Member member = (Member) getServletContext().getAttribute("member");
		
		var mem = em.find(Member.class,member.getId());
		int total = list.stream().mapToInt(sd -> sd.getQty() * sd.getProduct().getDetailPrice()).sum();
		System.out.println("total"+total);
		var sale = new Sale( LocalDate.now(),LocalTime.now(), total);
		for(SaleDetails d : list) {
			sale.addSaleDetail(d);
		}
		em.getTransaction().begin();
		em.persist(sale);
		em.getTransaction().commit();

	}
}
