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

	<app:header pageName="Product" icon="bi bi-tag-fill"></app:header>
	
	<div class="container mt-4 p-4">
		<c:set var="list" value="${applicationScope.products }"></c:set>
		<c:choose>
		<c:when test="${ not empty list }">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="text-color">No.</th>
						<th class="text-color">Name</th>
						<th class="text-color">Category</th>
						<th class="text-end text-color">Detail Price</th>
						<th class="text-end text-color">WholeSale Price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${list }" varStatus="count"  >
						<tr>
							<td>${count.index+1 }</td>
							<td>${p.name }</td>
							<td>${p.category.name }</td>
							<td class="text-end text-danger">${p.detailPrice }</td>
							<td class="text-end text-danger">${p.wholeSalePrice }</td>
							<td class="text-end">
								<a id="" class="btn-style text-end"><i class="bi bi-plus"></i> Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p class="text-primary">There is no category yet !</p>
		</c:otherwise>
		</c:choose>
			
		</div>
	<app:footer></app:footer>
</body>
</html>