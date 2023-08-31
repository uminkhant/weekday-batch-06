package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Member.Role;
import com.jdc.mkt.servlet.utils.FactoryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/signUp", "/admin/showMember", "/admin/editMember", "/admin/deleteMember" })
public class MemberServlet extends FactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var em = createEntityManager();
		req.setAttribute("memberRole", Role.values());	
		Member member = null;
		var idP = req.getParameter("id");
		
		if (null != idP && !idP.isEmpty()) {
			var id = Integer.parseInt(req.getParameter("id"));
			member = em.find(Member.class, id);			
		}

		switch (req.getServletPath()) {
		case "/signUp":
			getServletContext().getRequestDispatcher("/signUp.jsp").forward(req, resp);
			break;
		case "/admin/showMember":
			var query = em.createNamedQuery("getAllMembers", Member.class);
			req.setAttribute("members", query.getResultList());
			getServletContext().getRequestDispatcher("/admin/showMember.jsp").forward(req, resp);
			break;
		case "/admin/editMember":		
			req.setAttribute("member", member);
			getServletContext().getRequestDispatcher("/signUp.jsp").forward(req, resp);
			break;
		case "/admin/deleteMember":	
			em.getTransaction().begin();
			member.setDeleted(true);
			em.merge(member);
			em.getTransaction().commit();
			getServletContext().getRequestDispatcher("/admin/showMember").forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var idP = req.getParameter("id");
		var name = req.getParameter("name");
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		var city = req.getParameter("city");
		var township = req.getParameter("township");
		var street = req.getParameter("street");
		var roleName = req.getParameter("role");
		var pri = req.getParameter("phone1");
		var sec = req.getParameter("phone2");

		var em = createEntityManager();

		Member member = null;
		if (null != idP && !idP.isEmpty()) {
			var id = Integer.parseInt(idP);
			Role role = Role.valueOf(roleName);
			member = em.find(Member.class, id);
			member.setRole(role);
			member.setName(name);
			member.setLoginId(loginId);
			member.setPassword(password);

			var address = member.getAddress();
			address.setCity(city);
			address.setTownship(township);
			address.setStreet(street);
			member.setAddress(address);

			var contact = member.getContact();
			contact.setPrimaryPhone(pri);
			contact.setSecondaryPhone(sec);
			member.setContact(contact);

		} else {
			member = new Customer(name, loginId, password);
			member.addAddress(new Address(street, township, city));
			member.addContact(new Contact(pri, sec));
		}

		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
		closeEntityManager();
		resp.sendRedirect("/index.jsp");
	}

}
