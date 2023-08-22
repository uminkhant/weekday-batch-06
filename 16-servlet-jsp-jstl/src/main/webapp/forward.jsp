<jsp:include page="commons/header.jsp"></jsp:include>


<div class="container mt-4">
	<p class="text-primary"><%= request.getParameter("forward") %> </p>
	<p class="text-primay"><%= request.getParameter("message") %> </p>
</div>

<jsp:include page="commons/footer.jsp"></jsp:include>