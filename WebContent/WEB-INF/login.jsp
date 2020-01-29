<%@page import="java.util.ArrayList"%>
<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	
	<c:import url="inc/header.jsp"/>
	<c:import url="inc/login-header.jsp"/>
	
	<div class="container" style="margin-left: 200px; margin-top: 20px;">
	
			<form name="authForm" method="post">
			  <div class="form-row">
			    <div>
			      <div class="input-group">
			        	<div class="input-group-prepend">
			          		<div class="input-group-text">@</div>
			        	</div>
			        	<input type="text" name='AuthLogin' class="form-control" placeholder="Login" required style="width: 150px;">
			      	</div>
			    </div>
			    <div>
			      <input type="password" name='AuthPassword' class="form-control" placeholder="Password" style="width: 200px; margin-left: 50px;">
			    </div>
			  </div><br/>
			  <button type="submit" class="btn btn-info">Submit</button>
			</form>		

</div>
	
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</html>