<%@page import="com.jdc.mkt.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
		body{
			height: 100vh;
			display: flex;
			flex-direction:column; 
			align-items: center;
			
		}
		h1{
			color: aqua;
		}
		.anchor{
			text-decoration: none;
			color:red;
		}
		
	</style>
<title>Servlet Scope Demo</title>
</head>
<body>
	<h1>Servlet Scope</h1>

	<%! String COUNTER = "counter"; %>
			
	<%		
		Counter c1 = (Counter)request.getAttribute(COUNTER);
		Counter c2 = (Counter)session.getAttribute(COUNTER);
		Counter c3 = (Counter)application.getAttribute(COUNTER);
	%>
			
	
	<ol>
		<li>
			<a href="counterServlet" class="anchor">Request Scope : </a>
			<% 
				if(c1 != null){
			%>
			<%= c1.getValue().toString() %>
			<%}else{ %>
			<%= 0 %>
			<%} %>
		</li>
		<li>
			<a href="counterServlet" class="anchor">Session Scope :</a>
			<% 
				if(c2 != null){
			%>
			<%= c2.getValue().toString() %>
			<%}else{ %>
			<%= 0 %>
			<%} %>
		</li>
		<li>
			<a href="counterServlet" class="anchor">Application Scope :</a>
			<% 
				if(c3 != null){
			%>
			<%= c3.getValue().toString() %>
			<%}else{ %>
			<%= 0 %>
			<%} %>
		</li>
	</ol>
	
	<hr />
	
</body>
</html>









