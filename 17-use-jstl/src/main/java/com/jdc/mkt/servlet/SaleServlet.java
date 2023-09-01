package com.jdc.mkt.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Sale;
import com.jdc.mkt.entity.SaleDetails;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/saleHistory", "/sale", "/admin/searchDetail" })
@SuppressWarnings("unchecked")
public class SaleServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var category = req.getParameter("category");
		var customer = req.getParameter("customer");
		var product = req.getParameter("product");
		var from = req.getParameter("frm_date");
		var to = req.getParameter("to_date");
		var list = searchBy(customer, category, product, from, to);
		var total = list.stream().mapToInt(sd -> sd.getQty()*sd.getProduct().getDetailPrice()).sum();
		req.setAttribute("total", total);
		req.setAttribute("saleHistory", list);
		closeEntityManager();
		getServletContext().getRequestDispatcher("/admin/saleHistory.jsp").forward(req, resp);
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
		} else {
			req.setAttribute("message", "Please LoginId first before you paid !");
			getServletContext().getRequestDispatcher("/detailsCart.jsp").forward(req, resp);
		}

	}

	private List<SaleDetails> searchBy(String customerName, String categoryName, String productName,
			String fromSaleDate, String toSaleDate) {
		StringBuilder sb = new StringBuilder("select sd from SaleDetails sd where sd.sale.isDeleted = false");
		Map<String, Object> map = new HashMap<String, Object>();

		if (null != customerName && !customerName.isEmpty()) {
			sb.append(" and sd.sale.customer.name = :customer");
			map.put("customer", customerName);
		}

		if (null != categoryName && !categoryName.isEmpty()) {
			sb.append(" and sd.product.category.name = :category");
			map.put("category", categoryName);
		}

		if (null != productName && !productName.isEmpty()) {
			sb.append(" and sd.product.name = :product");
			map.put("product", productName);
		}

		if (null != fromSaleDate && !fromSaleDate.isEmpty()) {
			sb.append(" and sd.sale.saleDate >= :frmDate");
			
			map.put("frmDate", LocalDate.parse(fromSaleDate));
		}

		if (null != toSaleDate && !toSaleDate.isEmpty()) {
			sb.append(" and sd.sale.saleDate <= :toDate");
			map.put("toDate", LocalDate.parse(toSaleDate));
		}

		var em = createEntityManager();

		var query = em.createQuery(sb.toString(), SaleDetails.class);
		for (Entry<String, Object> m : map.entrySet()) {
			query.setParameter(m.getKey(), m.getValue());
		}
		return query.getResultList();

	}
}
