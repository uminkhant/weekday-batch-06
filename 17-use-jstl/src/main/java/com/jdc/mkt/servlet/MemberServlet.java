package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Member.Role;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/admin/addMember","/admin/showMember"})
public class MemberServlet extends FactoryServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var em = createEntityManager();
		var query = em.createNamedQuery("getAllMembers", Member.class);
		
		req.setAttribute("memberRole", Role.values());
		req.setAttribute("members", query.getResultList());
		
		//getServletContext().getRequestDispatcher(req.getServletPath().concat(".jsp")).forward(req, resp);
		getServletContext().getRequestDispatcher("/customer/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var name = req.getParameter("name");
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		var city = req.getParameter("city");
		var township = req.getParameter("township");
		var street = req.getParameter("street");
		String phones = req.getParameter("phone");
				
		Member member = new Customer(name, loginId, password, street, township, city);
		for(String phone :phones.split(",")) {
			var contact = new Contact(phone);
			member.addContact(contact);
		}
		
		var em = createEntityManager();
		em.getTransaction().begin();
			em.persist(member);	
		em.getTransaction().commit();
		closeEntityManager();
		
	}

}
