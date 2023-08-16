<%@page import="com.jdc.mkt.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Welcome</title>
	<style>
		.anchor{
			text-decoration: none;
		}
	</style>
</head>
<body>
	<h1>Listener</h1>
	<table class="table">
		<thead>
		<tr>
			<th>Product</th>
			<th>Category</th>
			<th>Price</th>
		</tr>
		</thead>
		<tbody>
		<% List<Product> products =(List<Product>) application.getAttribute("products"); %>
		<% for(Product p : products){ %>
		<tr>
			<td><%=p.getName() %> </td>
			<td><%=p.getCategory() %> </td>
			<td><%=p.getPrice() %> </td>
		</tr>
		<%} %>
		
		</tbody>
	</table>
</body>
</html>