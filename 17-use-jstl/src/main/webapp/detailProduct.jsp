<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/css/style.css" />
<title>Product Detail</title>
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
	<c:set var="p" value="${requestScope.product }"></c:set>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-3  text-center">
				<img src="/images/${p.image}" width="75%" alt="...">
			</div>

			<div class="col-md-8 ">
				<div class="card p-4">
					<div class="card-body">
						<h5 class="card-title text-color">Product Name : ${p.name }</h5>
						<p class="card-text">Category : ${p.category.name }</p>
						<p class="card-text">Price :${p.detailPrice }</p>
						<p class="card-text">${p.description }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<app:footer></app:footer>
</body>