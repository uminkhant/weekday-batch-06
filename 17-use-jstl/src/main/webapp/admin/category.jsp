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
	<app:header pageName="Category"></app:header>
	<div class="container mt-4 p-4 w-75">
		<h3 class="text-color">
			<i class="bi bi-tags-fill"></i>Category
		</h3>
		<div class="text-end">
			<a id="addNewBtn" class="btn-style me-2"><i class="bi bi-plus"></i>
				Add New</a>
		</div>
		<div>
			<c:set var="list" value="${applicationScope.categories }"></c:set>
			<c:choose>
				<c:when test="${ not empty list }">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="text-color">No.</th>
								<th class="text-color">Name</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${list }" varStatus="count">
								<tr>
									<td>${count.index+1 }</td>
									<td>${c.name }</td>
									<td class="text-end"><a onclick="myFunction(this)"
										class="editBtn btn btn-outline-warning "><i
											class="bi bi-plus"></i> Edit</a> <c:url var="delete"
											value="/admin/deleteCategory?id=${c.id }"></c:url> <a
										href="${delete }" class="btn btn-outline-danger ">Delete</a></td>
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
	</div>
	<app:footer></app:footer>

	<!-- modal -->

	<div id="modal" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<c:url var="add" value="/admin/addCategory"></c:url>
			<div class="modal-content">
				<form action="${ add }" method="post">
					<div class="modal-header">
						<h5 class="modal-title">Add Category</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<input class="form-control" type="text" name="category"
							placeholder="Category name" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-outline-warning"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-outline-danger">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
	const myModal = document.getElementById('addNewBtn')
	const modal = document.getElementById('modal')

	myModal.addEventListener('click', () => {
		const dialog = new bootstrap.Modal(modal)
		dialog.show()
	})

	</script>
	<script>
	function myFunction(element){
	    if (element){ 
	    	const dialog = new bootstrap.Modal(modal)    	
			dialog.show()
	    }
	}

	</script>
</body>

</html>