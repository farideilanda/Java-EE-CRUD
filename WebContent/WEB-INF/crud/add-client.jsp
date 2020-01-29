<%@page import="java.util.ArrayList"%>
<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>CRUD</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
  

</head>
<body>
	<c:import url="../inc/header.jsp"/>
	<c:import url="../inc/add-client-header.jsp"/>
	
	<div class="container" style="margin-left: 200px; margin-top: 20px;">
				<div style="height: 60px;">
					<c:if test = "${ requestScope.statusMessage == '1' }">
				        <div class="alert alert-success" role="alert" style="width: 980px;">
					  		New Client ${ requestScope['client'].firstname } ${ requestScope['client'].lastname } with Login ${ requestScope['client'].login } added successfully !
						</div>	
				    </c:if>
				    <c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}">
				        <div class="alert alert-danger" role="alert" style="width: 980px;">
					  		Passwords errors (unmatched) !
						</div>	
				    </c:if>
				</div>

				<form name="myform" method="post" style="width: 80%;">
					<div class="form-row">
						<div class="col">
							<input type="text" style='width: 300px;' <c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}"> class="form-control is-valid" value="${requestScope['client'].firstname}" </c:if> name='FormFirstname' class="form-control" placeholder="First name" required> 
							<c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}">
								<div class="valid-feedback">
					        		Looks good!
					      		</div>
							</c:if>
						</div>
						<div class="col">
							<input type="text" style='width: 300px;' <c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}"> class="form-control is-valid" value="${requestScope['client'].lastname}" </c:if> name='FormLastname' class="form-control" placeholder="Last name" required> 
							<c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}">
								<div class="valid-feedback">
					        		Looks good!
					      		</div>
							</c:if>
						</div>
					</div>
					<br/>
					<div class="form-row"> 
						<div class="col">
							<input type="text" style='width: 300px;' <c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}"> class="form-control is-valid" value="${requestScope['client'].login}" </c:if> name='FormLogin' class="form-control" placeholder="Login" required>
							<c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}">
								<div class="valid-feedback">
					        		Looks good!
					      		</div>
							</c:if>
						</div>
							
							
						<div class="col">
							<input type="password" style='width: 300px;' <c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}"> class="form-control is-invalid" </c:if> name='FormPassword' class="form-control" placeholder="Password" required> 
							<c:if test = "${ requestScope.statusMessage == '0' and !empty requestScope.passwordsErrors}">
								<div class="invalid-feedback">
					        		Unmatched passwords!
					      		</div>
							</c:if>
						</div>
					</div>
					<br/>
					<div class="form-row"> 
						<div class="col">
							&nbsp;
						</div>
						<div class="col">
							<input type="password" style='width: 300px;' name='FormPasswordBis' class="form-control" placeholder="Confirm Password" required> 
						</div>
					</div>
					<br/>
					<button type="submit" style='width: 100px;' class="btn btn-primary">Submit</button>
				</form>
			</div>
	</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>