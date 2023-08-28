<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
	<app:header pageName="Welcome" icon="bi bi-house"></app:header>
	<div class="container mt-4">
		<div class="row">
			<c:set var="list" value="${applicationScope.products }"></c:set>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach var="p" items="${list }">
						<div class="col-sm-3 p-2">
							<div class="card p-2">
								<img src="images/${p.image}" class="card-img-top p-4"  alt="..." >
								<div class="card-body">
									<h5 class="card-title text-color">${p.name }</h5>
									<p class="card-text">${p.description }</p>
									<div>
										<a href="#" class="btn-style">Details</a>
										<c:url var="cart" value="/addToCart?id=${p.id }"></c:url> 
										<a href="${cart }" class="btn-style">Add To Cart</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p class="text-danger">There is no product</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<app:footer></app:footer>
</body>