<%@page import="java.util.List"%>
<%@page import="com.jdc.mkt.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container mt-4">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty applicationScope.persons }">
						<c:forEach begin="2" end="3" var="p" items="${applicationScope.persons }">
							<tr>
								<td>${p.name }</td>
								<td>${p.age }</td>
								<c:if test="${p.age >= 30}" >
									<td>YY</td>
								</c:if>
								
							</tr>
							
						</c:forEach>
					</c:when>
					<c:otherwise>
							<p>There is no person</p>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
			
	</div>
	<c:url var="fr" value="fromForward.jsp">
		<c:param name="message" value="From jstl message"></c:param>
	</c:url>
	<a href="${fr }">Forward jsp</a>
	
	
	
</body>









