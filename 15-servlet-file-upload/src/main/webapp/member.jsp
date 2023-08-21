<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<form action="member" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="" class="form-label">User Name</label>
				<input type="text" class="form-control" name="name" />
			</div>
			<div class="form-group">
				<label for="" class="form-label">Login Id</label>
				<input type="text" class="form-control" name="loginId" />
			</div>
			<div class="form-group">
				<label for="" class="form-label">Password</label>
				<input type="password" class="form-control" name="password"/>
			</div>
			<div class="form-group">
				<select name="role">
					<option value="ADMIN">ADMIN</option>
					<option value="USER">MEMBER</option>
				</select>
			</div>
			<div class="form-group">
			<label for="" class="form-label">Email</label>
			<input type="email" class="form-control" name="email" />
			</div>
			
			<div class="form-group">
				<label for="" class="form-label">Image</label>
				<input type="file" accept="image/*" class="form-control" name="image" />
			</div>
			<button type="submit" class="btn btn-outline-primary mt-2">Save</button>
		</form>
	</div>
</body>
</html>









