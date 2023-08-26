<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="pageName" required="true"%>
<%@ attribute name="icon" required="true"%>

<c:url var="addMember" value="/addMember" />
<c:url var="showMember" value="/showMember" />
<c:url var="category" value="/category" />
<c:url var="addProduct" value="/addProduct" />
<c:url var="showProduct" value="/showProduct" />
<c:url var="index" value="/" />

<nav class="navbar navbar-expand-lg ">
	<div class="container-fluid">
		<a class="navbar-brand " href="${index }">Product Sales</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#myNav" aria-controls="myNav" aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="myNav">
			<ul class="navbar-nav  mb-2 mb-lg-0">

				<li class="nav-item"><a
					class="nav-link  ${pageName eq 'Category' ? 'active' : '' }"
					href="${category }">Category</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle  ${pageName eq 'Product' ? 'active' : '' }"
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
						<li><a class="dropdown-item" href="${addMember }">Add
								Member</a></li>
						<li><a class="dropdown-item" href="${showMember }">Show
								Member</a></li>
					</ul></li>

			</ul>

		</div>
		<c:set var="saleDetails" value="${sessionScope.saleDetails }"></c:set>
		<c:url var="details" value="/detailsCart"></c:url>
		<a href="${details }" class="nav-link"> <i
			class="bi bi-cart-fill text-danger position-relative me-4"> Cart
				<c:if test="${not empty saleDetails }">
					<span
						class="position-absolute top-0 start-80 translate-middle badge rounded-pill bg-danger">
						${saleDetails.size()} </span>
				</c:if>
		</i></a>
	</div>
</nav>

<section class="container mt-4 text-center">
	<h3 class="text-color">
		<i class="${icon }"></i> ${pageName }
	</h3>

</section>






