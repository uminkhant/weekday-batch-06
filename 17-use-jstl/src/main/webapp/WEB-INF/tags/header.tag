<%@tag import="com.jdc.mkt.entity.SaleDetails"%>
<%@tag import="java.util.List"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="pageName" required="true"%>
<c:url var="signUp" value="/signUp" />
<c:url var="showMember" value="/admin/showMember" />
<c:url var="category" value="/admin/category" />
<c:url var="addProduct" value="/admin/addProduct" />
<c:url var="showProduct" value="/admin/showProduct" />
<c:url var="details" value="/detailsCart" />
<c:url var="signIn" value="/signIn" />
<c:url var="signUp" value="/signUp" />
<c:url var="sale" value="/admin/saleHistory" />
<c:url var="index" value="/" />
<link rel="stylesheet" href="/styles/css/style.css" />

<c:set var="member" value="${ applicationScope.member}"></c:set>

<nav class="navbar navbar-expand-lg">
	<div class="container-fluid">
		<a class="navbar-brand " href="${index }">Product Sales</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#myNav" aria-controls="myNav" aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<c:if test="${not empty member and member.role eq 'ADMIN' }">
			<div class="collapse navbar-collapse" id="myNav">
				<ul class="navbar-nav  mb-2 mb-lg-0">

					<li class="nav-item"><a
						class="nav-link  ${pageName eq 'Category' ? 'active' : '' }"
						href="${category }">Category</a></li>
					<li class="nav-item"><a
						class="nav-link  ${pageName eq 'Sale' ? 'active' : '' }"
						href="${sale }">Sale History</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle  ${pageName eq 'Product'? 'active' : '' }"
						href="#" id="drop" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> Product </a>
						<ul class="dropdown-menu" aria-labelledby="drop">
							<li><a class="dropdown-item" href="${addProduct }">Add
									Product</a></li>
							<li><a class="dropdown-item" href="${showProduct }">Show
									Product</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle  ${pageName eq 'Member' ? 'active' : '' }"
						href="#" id="drop" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> Member </a>
						<ul class="dropdown-menu" aria-labelledby="drop">
							<li><a class="dropdown-item" href="${signUp}">Add Member</a></li>
							<li><a class="dropdown-item" href="${showMember }">Show
									Member</a></li>
						</ul></li>
				</ul>
			</div>
		</c:if>
		<div class="d-flex text-end me-4">
			<c:choose>

				<c:when test="${not empty member }">
					<span class="d-flex text-color me-3"> <i
						class="bi bi-person-fill"></i><a class="nav-link" id="logout"
						href="#">${member.name }</a>
					</span>
				</c:when>
				<c:otherwise>
					<span class="d-flex text-color me-3"> <i
						class="bi bi-person"></i>&nbsp;<a class="nav-link mr-2"
						id="signUp" href="${signUp }">SignUp</a>
					</span>
					<span class="d-flex text-color me-3"> <i
						class="bi bi-person-fill"></i>&nbsp;<a class="nav-link"
						id="signIn" href="#">SignIn</a>
					</span>

				</c:otherwise>

			</c:choose>

			<c:set var="saleDetails" value="${sessionScope.saleDetails }"></c:set>

			<a href="${details }" class="nav-link"> <i
				class="bi bi-cart-fill text-color position-relative me-4"> Cart
					<c:if test="${ not empty saleDetails }">

						<span
							class="position-absolute top-25 start-50 translate-middle badge rounded-pill bg-danger">
							${saleDetails.size()} </span>
					</c:if>
			</i></a>
		</div>
	</div>
</nav>

<section class="container mt-4 text-center">

	<p class="text-danger text-end">${not empty requestScope.message ? requestScope.message :''}</p>




	<!-- modal login-->

	<div id="formSignIn" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<form class="form" action="${ signIn }" method="post">
					<div class="modal-header">
						<h5 class="modal-title text-color">Login Form</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<input class="form-control" type="text" name="loginId"
							placeholder="type LoginId" />
					</div>
					<div class="modal-body">
						<input class="form-control" type="text" name="password"
							placeholder="type password" />
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
	<!-- modal logout-->

	<div id="formLogout" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/logout">
					<div class="modal-header">
						<h5 class="modal-title text-color">Logout</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p>Are you sure want to logout !</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-outline-warning"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-outline-danger">Logout</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		const login = document.getElementById('signIn')
		const formLogin = document.getElementById('formSignIn')

		login.addEventListener('click', function() {
			const dialog = new bootstrap.Modal(formLogin)
			dialog.show()
		})
	</script>
	<script>
		const logout = document.getElementById('logout')
		const formLogout = document.getElementById('formLogout')

		logout.addEventListener('click', function() {
			const dialog = new bootstrap.Modal(formLogout)
			dialog.show()
		})
	</script>
</section>






