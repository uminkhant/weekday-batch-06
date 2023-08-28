<%@page import="com.jdc.mkt.entity.SaleDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jdc.mkt.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/styles/css/style.css" />
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
	<c:url var="clearCart" value="/clearCart" />

	<app:header pageName="" icon=""></app:header>
	<c:set var="saleDetails" value="${sessionScope.saleDetails }"/>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8">
				<h3 class="text-color">Voucher Detail</h3>
				<c:choose>
					<c:when test="${not empty saleDetails }">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>No</th>
									<th>Name</th>
									<th>Category</th>
									<th>Price</th>
									<th>Qtys</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="s" items="${saleDetails }" varStatus="counter">
									<tr>
										<td>${counter.index+1 }</td>
										<td>${s.product.name }</td>
										<td>${s.product.category.name }</td>
										<td>${s.product.detailPrice }</td>

										<td>${s.qty }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
				</c:choose>
			</div>
			<div class="col-md-4">
				<h3 class="text-color">Voucher</h3>
				<form action="" class="form">
					<c:choose>
						<c:when test="${not empty saleDetails }">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Price</th>
										<th>Qtys</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="s" items="${saleDetails }" varStatus="counter">
										<tr>
											<td>${counter.index+1 }</td>
											<td>${s.product.name }</td>
											<td>${s.product.detailPrice }</td>
											<td>${s.qty }</td>
											<td>${s.product.detailPrice*s.qty }</td>
										</tr>
									</c:forEach>

									<tr>
										<td colspan="4">Totals</td>
										<%
											@SuppressWarnings("unchecked")
											List<SaleDetails> list = (List<SaleDetails>)session.getAttribute("saleDetails");
											int total = list.stream().mapToInt(sd -> sd.getQty()*sd.getProduct().getDetailPrice()).sum();
											request.setAttribute("total", total);
										%>
										<td class="text-danger">${total}</td>
									</tr>
								</tbody>
							</table>
							<div class="text-end">
								<a class="btn btn-outline-warning" href="${clearCart }">Clear
									Cart</a>
								<button type="submit" class="btn btn-outline-danger">Checkout</button>
							</div>
						</c:when>
						<c:otherwise>
							<p class="text-warning">There is no product in cart</p>
						</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
	</div>
	<app:footer></app:footer>
</body>