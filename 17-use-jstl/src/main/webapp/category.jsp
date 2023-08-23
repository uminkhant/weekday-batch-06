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
	<app:header pageName="Category" icon="bi bi-tags-fill"></app:header>
	<div class="container mt-4">

		<a id="addNewBtn" class="btn-style"><i class="bi bi-plus"></i> Add New</a>
		<div class="show">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>No.</th>
						<th>Name</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<app:footer></app:footer>

	<div id="modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addCategory" method="post">
					<div class="modal-header">
						<h5 class="modal-title">Add Category</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<input type="text" name="category" placeholder="Category name" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:url var="modal" value="/styles/js/app.js"></c:url>
	<script src="${modal }"></script>
</body>

</html>