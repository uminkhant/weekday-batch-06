package com.jdc.mkt.listener_filter;

import java.io.IOException;

import com.jdc.mkt.entity.Member;
import com.jdc.mkt.entity.Member.Role;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/admin/*")
public class ApplicationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		ServletContext context = request.getServletContext();
		Member member = (Member)context.getAttribute("member");

		if (null != member && member.getRole() == Role.ADMIN) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("/error.jsp");
		}
	}

}
