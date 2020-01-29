<%@page import="java.util.ArrayList"%>
<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:if test = "${ !empty requestScope.clientDeleted }">
<meta http-equiv="refresh" content="2;URL=all">
</c:if>
	
<title>CRUD</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
	<%! int cpt= 1;%>
	<%
	//User user;
	//ArrayList<User> u = (ArrayList) request.getAttribute("usersList");
	%>

	<c:import url="inc/header.jsp"/>
	<c:import url="inc/clients-header.jsp"/>
			
			<div class='container' style="margin-left: 190px;">
			
			<div style="height: 60px;">
					<c:if test = "${ !empty requestScope.clientDeleted }">
				        <div class="alert alert-warning" role="alert" style="width: 980px;">
					  		Client with Login ${ requestScope.clientDeleted } deleted successfully !
						</div>	
				    </c:if>
				</div>
			
			<a href="../users/add" class="btn btn-info" style="width: 120px;">New Client</a>
				<table class="table" style="width: 89%; margin-top: 8px;">
				  <thead class="thead-light">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">First name</th>
				      <th scope="col">Last name</th>
				      <th scope="col">Login</th>
				      <th scope="col">Password</th>
				      <th scope="col">Edit</th>
				      <th scope="col">Delete</th>
				    </tr>
				  </thead>
				  <tbody>
		<%
			/*for(int i = 0 ; i < u.size(); i++){
				user= u.get(i);*/
			%>
			
			<c:forEach items="${ requestScope.clientsList }" var ="client" varStatus="cpt">
			  <tr>
			  		  <th scope="col">${cpt.count }</th>
			  		  <th scope="col">${client.firstname }</th>
				      <th scope="col">${client.lastname }</th>
				      <th scope="row">${client.login }</th>
				      <th scope="col">
				      	<c:forEach var="i" begin="1" end="${fn:length(client.password)}" step="1">
						    *
						</c:forEach>
				      </th>
				      <th scope="col"><a href="update?login=${client.login }" class="btn btn-primary">edit</a></th>
				      <th scope="col"><a href="delete?login=${client.login }" class="btn btn-danger">delete</a></th>
			</tr>
			</c:forEach>
			<%
			//}
			%>
				  </tbody>
				</table>
			</div>
</div>
	

	

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>