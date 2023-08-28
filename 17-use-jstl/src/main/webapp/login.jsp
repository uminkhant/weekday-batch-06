<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/css/style.css" />
<title>Login Form</title>
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
	<app:header pageName="Login Form" icon="bi bi-person-fill"></app:header>
	<c:url var="login" value="/login"></c:url>
	<div class="container mt-4 text-center w-50">
		<form action="${ login }" method="post">
			<div class="form-group text-start">
				<label for="" class="form-label text-color">Login Id</label><input
					type="text" class="form-control" name="loginId" />
			</div>
			<div class="form-group text-start">
				<label for="" class="form-label text-color">Password</label><input
					type="password" class="form-control" name="password" />
			</div>
			<div class="form-group text-end mt-2">
				<button class="btn btn-outline-warning">Cancel</button>
				<button class="btn btn-outline-danger">Login</button>
			</div>
		</form>
	</div>
	<app:footer></app:footer>
</body>