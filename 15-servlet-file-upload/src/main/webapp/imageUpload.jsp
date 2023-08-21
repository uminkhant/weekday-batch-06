<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>Image Upload</title>
</head>
<body>
	<div class="container mt-4">
		<form action="uploadImage" class="form" method="post" enctype="multipart/form-data">
			<label for="" class="form-label text-success">Image</label>
			<input type="file" accept="image/*" class="form-control mb-2" name="imageUpload" />
			<button type="submit" class="btn btn-outline-primary mb-4">Upload</button>
		</form>
		
		<% 
		
		if(request.getAttribute("image") != null){
		%>
			<img src = <%= request.getAttribute("image") %> alt=""  width="200px" height="200px"/>
		<%}else {%>
			<p class="text-danger text-lg">There is no image !</p>
		<%} %>
	</div>	
</body>
</html>









