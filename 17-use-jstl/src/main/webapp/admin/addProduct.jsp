<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
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
	<c:url var="addProduct" value="/admin/addProduct"></c:url>
	<app:header pageName="Product"></app:header>
	<c:set var="p" value="${requestScope.product }"></c:set>
	<div class="container mt-4 p-4 w-50">
		<h2 class="text-color"><i class="bi bi-bookmark-plus-fill"></i>Add Product</h2>
		<form action="${addProduct }" class="form" method="post"
			enctype="multipart/form-data">
			<input type="text" name="id" hidden="true" value="${not empty p ? p.id:'' }" />
			<div class="form-group mb-2 ">
				<label for="name" class="form-label text-color">Name </label> <input id="name"
					type="text" class="form-control" name="name" value="${not empty p ? p.name:'' }"/>
			</div>
			<div class="form-group mb-2 ">
				<label for="cat" class="form-label text-color">Category </label>
				<select class="form-select" name="category" id="cat">
					<c:forEach var="c" items="${applicationScope.categories }">
						<option value="${c.id}">${c.name }</option>
					</c:forEach> 
				
				</select>
			</div>
			<div class="form-group mb-2 ">
				<label for="dt" class="form-label text-color">Detail Price</label> <input
					id="dt" type="text" class="form-control" name="dtPrice" value="${not empty p ? p.detailPrice:'' }"/>
			</div>
			
			<div class="form-group mb-2 ">
				<label for="img" class="form-label text-color">Image</label> <input id="img "
					class="form-control" type="file" accept="image/*" name="image" value="${not empty p ? p.image:'' }"/>
			</div>
			<div class="form-group mb-2 ">
				<label for="desc" class="from-label text-color">Description</label> <input
					id="desc" class="form-control" type="text" name="desc"
					placeholder="Decription" value="${not empty p ? p.description:'' }"/>
			</div>
			<div class="text-end ">
			<button class="btn btn-outline-warning mt-2">Clear</button>
				<button type="submit" class="btn btn-outline-danger mt-2">Save</button>
			</div>
		</form>
	</div>
	<app:footer></app:footer>
	
</body>