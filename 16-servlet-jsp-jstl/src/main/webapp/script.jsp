



<%@page import="java.util.Date"%>
<jsp:include page="commons/header.jsp"></jsp:include>


<div class="container">
	<h1 class="text-primary">Script tag</h1>
	
	<%! 
		Date date = new Date();
		Date getDate(){
			return date;
		}
	%>
	<% if( date != null){ %>
		<p class="text-secondary"><%= getDate() %></p>
	<%} %>
	
	<div>
		Date = <%= date.toString()%>
	</div>
</div>

<jsp:include page="commons/footer.jsp"></jsp:include>
