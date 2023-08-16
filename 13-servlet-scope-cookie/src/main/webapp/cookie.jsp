<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
	<style>
	body{
		display:  flex;
		flex-direction:column;
		align-items:center;
		justify-content: center;
	}
		
		.login{
			width: 300px;
			height:200px;
			color:red;
			border:2px dotted;
			font-family: "Courier New",Courier;
			
		}
		.form-group{
			padding : 5px;
		}
		.form-control{
			margin-left: 20px;
		}
		.btn{
			width:100px;
			margin-left: 110px;
		}
		.legend{
			font-size: 2em;
		}
		
	</style>
</head>
<body>
<h1> Cookies Test</h1>
<div class=""></div>
	<fieldset class ="login">
		<legend class="legend">Login Form</legend>
		<form action="cookie" class="form" method="post">
			<div class="form-group">
				<label >UserName</label>
				<% if(request.getAttribute("name") != null){ %>
				<input style="margin-right:1px;" type="text" class="form-control" name ="username" 
				value = <%=request.getAttribute("name") %>/>
				<%}else{ %>
				<input style="margin-right:1px;" type="text" class="form-control" name ="username"/>		
				<%} %>
			</div>
			<div class="form-group">
				<label for="" >Password</label>
				<% if(request.getAttribute("pass") != null){ %>
				<input type="text" class="form-control" name="password"
				value = <%=request.getAttribute("pass") %>
				/>
				<%}else{ %>
				<input type="text" class="form-control" name="password"/>
				<%} %>
			</div>
			<button class= "btn" type="submit">Login</button>
		</form>
	</fieldset>
</body>
</html>