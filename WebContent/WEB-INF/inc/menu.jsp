<%@page import="java.util.ArrayList"%>
<%@page import="beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div class="container" style="margin-left: 190px; margin-top: 20px;">
			<div style="float: left; width: 80%;">
				<c:choose>
					    <c:when test="${ !empty sessionScope['administrator'].login }">
					        <a href="users/add" class="btn btn-info" style="width: 200px;">Add new Client</a> <br/><br/>
							<a href="users/all" class="btn btn-info" style="width: 200px;">Display Clients</a> <br/>
					    </c:when>    
					    <c:otherwise>
					        &nbsp;
					    </c:otherwise>
					</c:choose>
			</div>
			<div style="float: right; width: 20%;">
				    <c:choose>
					    <c:when test="${ !empty sessionScope['administrator'].login }">
					        <a href="logout" class="btn btn-secondary" style="width: 100px;">Logout</a> <br/><br/>
					    </c:when>    
					    <c:otherwise>
					        <a href="login" class="btn btn-warning" style="width: 100px;">Login</a> <br/><br/>
					    </c:otherwise>
					</c:choose>
				
			</div>
		</div>
