<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/css/style.css" />
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body>
	<app:header pageName="Show Member" icon="bi bi-person-fill"></app:header>

	<div class="container mt-4">
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="text-color">No</th>
					<th class="text-color">Name</th>
					<th class="text-color">Login Id</th>
					<th class="text-color">Password</th>
					<th class="text-color">Member Type</th>
					<th class="text-color">City</th>
					<th class="text-color">Township</th>
					<th class="text-color">Street</th>					
					<th class="text-color">Phone</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="list" value="${requestScope.members }"></c:set>
				<c:choose>
					<c:when test="${not empty list }">
						<c:forEach var="m" items="${list }" varStatus="c">
							<tr>
								<td>${c.index+1 }</td>
								<td>${m.name }</td>
								<td>${m.loginId }</td>
								<td>${m.password }</td>
								<td>${m.role }</td>
								<td>${m.address.city }</td>
								<td>${m.address.township }</td>
								<td>${m.address.street }</td>
															
								<td>
								<c:forEach var="phone" items="${m.contacts }">
									<p>${phone.phone }</p>
								</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="text-primary">There is no member !</p>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<app:footer></app:footer>
</body>