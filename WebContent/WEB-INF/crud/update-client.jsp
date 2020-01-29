<%@page import="java.util.ArrayList"%>
<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<c:if test = "${ !empty requestScope.clientUpdated }">
<meta http-equiv="refresh" content="2;URL=all">
</c:if>

<meta charset="UTF-8">
<title>CRUD</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
  

</head>
<body>
	<c:import url="../inc/header.jsp"/>
	<c:import url="../inc/update-client-header.jsp"/>
	
	<div class="container" style="margin-left: 200px; margin-top: 20px;">
				<div style="height: 60px;">
					<c:if test = "${ !empty requestScope.clientUpdated }">
				        <div class="alert alert-success" role="alert" style="width: 980px;">
					  		Client with Login ${ requestScope['clientUpdated'].login } updated successfully !
						</div>	
				    </c:if>
				</div>

				<form name="myform" method="post" style="width: 80%;">
					<div class="form-row">
						<div class="col">
							<input type="text" style='width: 300px;' name='FormFirstname' value="${ requestScope['client'].firstname }" class="form-control" placeholder="First name" required> 
						</div>
						<div class="col">
							<input type="text" style='width: 300px;' name='FormLastname' value="${ requestScope['client'].lastname }" class="form-control" placeholder="Last name" required> 
						</div>
					</div>
					<br/>
					<div class="form-row"> 
						<div class="col">
							<input type="text" style='width: 300px;' name='FormLogin' value="${ requestScope['client'].login }" class="form-control" placeholder="Login" readonly required>
						</div>
						<div class="col">
							<input type="password" style='width: 300px;' name='FormPassword' value="${ requestScope['client'].password }" class="form-control" placeholder="Password" required> 
						</div>
					</div>
					<br/>
					
					<br/>
					<button type="submit" style='width: 100px;' class="btn btn-primary">Submit</button>
				</form>
			</div>
	</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>