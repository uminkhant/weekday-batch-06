<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/css/style.css" />
<title>Show member</title>
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
	<app:header pageName="Member"></app:header>

	<div class="container mt-4">
		<h3 class="text-color">
			<i class="bi bi-person-fill"></i>Show Person
		</h3>
		<div class="table-responsive">
			<table class="table table-hover ">
				<thead>
					<tr>
						<th class="text-color">No</th>
						<th class="text-color">Name</th>
						<th class="text-color ">Login Id</th>
						<th class="text-color">Password</th>
						<th class="text-color">Member Type</th>
						<th class="text-color">City</th>
						<th class="text-color">Township</th>
						<th class="text-color">Street</th>
						<th class="text-color">Primary Phone</th>
						<th class="text-color">Secondary Phone</th>
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
									<td>${m.contact.primaryPhone }</td>
									<td>${m.contact.secondaryPhone }</td>
									<td>
										<c:url var="edit" value="/admin/editMember?id=${m.id }"></c:url>
										<a href="${edit }" class="btn-style">Edit</a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p class="text-danger">There is no member !</p>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<app:footer></app:footer>

</body>