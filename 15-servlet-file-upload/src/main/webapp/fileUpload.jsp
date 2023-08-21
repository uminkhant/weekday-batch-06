<%@page import="java.util.List"%>
<%@page import="com.jdc.mkt.file.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


	<div class="container p-5">
		<h1 class="mt-3 text-primary">File Upload</h1>
		<form action="uploadFile" class="form" enctype="multipart/form-data"
			method="post">
			<div class="mb-3">
				<label for="" class="form-label"></label> <input type="file"
					class="form-control mb-2" name="fileUpload" />
				<button class="btn btn-primary" type="submit">Upload File</button>
			</div>

		</form>
	</div>

	<%
	@SuppressWarnings("unchecked")
	List<Member> list = (List<Member>) application.getAttribute("members");
	%>
	<div class="container p-5">
		<%
		if (list != null) {
		%>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Role</th>
					<th>LoginId</th>
					<th>Password</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Member m : list) {
				%>
				<tr>
					<td><%=m.getId()%></td>
					<td><%=m.getName()%></td>
					<td><%=m.getRole().name()%></td>
					<td><%=m.getLoginId()%></td>
					<td><%=m.getPassword()%></td>
					<td><%=m.getEmail()%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
		<%} else {%>
			<p class="text-danger text-lg">There is no member yet !</p>
		<%
		}
		%>


	</div>
</body>
</html>