<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/css/style.css" />
<title>Home</title>
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

	<app:header pageName="Product"></app:header>

	<div class="container mt-4 p-4">
		<h3 class="text-color">
			<i class="bi bi-tag-fill"></i>Show Product
		</h3>
		<c:set var="list" value="${applicationScope.products }"></c:set>
		<c:choose>
			<c:when test="${ not empty list }">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-color">No.</th>
								<th class="text-color">Name</th>
								<th class="text-color">Category</th>
								<th class="text-end text-color">Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${list }" varStatus="count">
								<tr>
									<td>${count.index+1 }</td>
									<td>${p.name }</td>
									<td>${p.category.name }</td>
									<td class="text-end text-danger">${p.detailPrice }</td>
									<td class="text-end"><c:url var="edit"
											value="/admin/editProduct?id=${p.id }"></c:url> <a
										href="${edit }" class="btn btn-outline-warning "><i
											class="bi bi-plus"></i> Edit</a>
									
										<c:url var="delete" value="/admin/deleteProduct?id=${p.id }"></c:url>
										<a href="${delete }" class="btn btn-outline-danger ">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<p class="text-danger">There is no category yet !</p>
			</c:otherwise>
		</c:choose>

	</div>
	<app:footer></app:footer>

</body>
</html>