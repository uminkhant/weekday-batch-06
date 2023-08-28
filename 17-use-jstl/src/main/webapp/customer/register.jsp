<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/styles/css/style.css" />
<title>Register</title>
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
	<c:url var="addMember" value="/admin/addMember"></c:url>
	<app:header pageName="Registering Form" icon="bi bi-file-earmark-person"></app:header>

	<div class="container mt-4 p-4">
		
			
				<form action="${addMember }" class="form" method="post">
					<div class="row  ">

						<div class="card col-sm-6 p-2">
							<div class="card-title text-secondary">Member Information</div>
							<div class="card-body p-2 mb-2">
								<div class="form-group mb-2 text-start">
									<label for="name" class="form-label text-color ">Name </label>
									<input id="name" type="text" class="form-control" name="name" />
								</div>

								<div class="form-group mb-2 text-start">
									<label for="dt" class="form-label text-color">LoginId</label> <input
										id="dt" type="text" class="form-control" name="loginId" />
								</div>
								<div class="form-group mb-2 text-start">
									<label for="ws" class="form-label text-color">Password</label>
									<input id="ws" type="password" class="form-control"
										name="password" />
								</div>
								<div class="form-group mb-2 text-start">
									<label for="ws" class="form-label text-color">Confirm
										Password</label> <input id="ws" type="password" class="form-control"
										name="confirm" />
								</div>
							</div>
						</div>
						
						<div class="card col-sm-6 p-2">
							<div class="card-title text-secondary">Contact Infomation
								must be fill !</div>
							<div class="card-body p-2 mb-2">
								<div class="form-group mb-2 text-start">
									<label for="city" class="form-label text-color ">City </label>
									<input id="city" type="text" class="form-control" name="city" />
								</div>

								<div class="form-group mb-2 text-start">
									<label for="township" class="form-label text-color">Township</label>
									<input id="township" type="text" class="form-control"
										name="township" />
								</div>
								<div class="form-group mb-2 text-start">
									<label for="street" class="form-label text-color">Address</label>
									<input id="street" type="text-area" class="form-control"
										name="street" />
								</div>
								<div class="form-group mb-2 text-start">
									<label for="phone" class="form-label text-color">Phone</label>
									<input id="phone" type="text" class="form-control" name="phone" />
								</div>
							</div>

						</div>
					</div>

					<div class="text-end ">
						<button class="btn btn-outline-warning mt-2">Clear</button>
						<button type="submit" class="btn btn-outline-danger mt-2">Save</button>
					</div>
				</form>
			</div>
		
	

	<app:footer></app:footer>
</body>