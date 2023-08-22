<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="commons/header.jsp"></jsp:include>

<h1>Category</h1>
<div class="container mt-4">

	<div class="insert">
		<form action="" class="form">
			<label for="" class="form-label">Catgory</label>
			<input type="text" class="form-control" name = "category"/>
			<button class="btn btn-primary">Save</button>
		</form>
	</div>
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
<jsp:include page="commons/footer.jsp" />