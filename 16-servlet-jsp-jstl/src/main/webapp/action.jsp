

<jsp:include page="commons/header.jsp"></jsp:include>


<div class="container">
	<p class="text-primary">Action Tags</p>

	<ul>
		<li>
			<h3 class="text-secondary">Forward Tag</h3>
			<a href="fromForward.jsp" class="nav-link text-primary">Forward Test</a>
		</li>
		<li>
			<h3 class="text-secondary">Bean tag</h3>
			<jsp:useBean id="person" class="com.jdc.mkt.Person" scope="session"></jsp:useBean>
			<jsp:setProperty property="name" name="person" value="William"/>
			<jsp:setProperty property="age" name="person" value="23"/>
			
			<p> Person name :<jsp:getProperty property="name" name="person"/> </p>
			<p> Person age :<jsp:getProperty property="age" name="person"/> </p>
		</li>
	</ul>
	

</div>
<jsp:include page="commons/footer.jsp"></jsp:include>

