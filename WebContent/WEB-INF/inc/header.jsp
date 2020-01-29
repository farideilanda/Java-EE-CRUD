<%@page import="java.util.ArrayList"%>
<%@page import="beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<div class="container" style="margin-top: 5px; width: 900px;">
			<table style="width: 90%; margin-left: 150px;">
				<colgroup span="1" width="80%"></colgroup>
				<colgroup span="1" width="20%"></colgroup>
				
				<tr>
					<th>&nbsp;</th>
					<th>
					
					<c:if test = "${ !empty sessionScope['administrator'].login }">
				         <h3><button class="btn btn-link" style="width: 200px;" title="You are connected !" readonly>${ sessionScope.administrator.login }</button></h3>
				    </c:if>
				   
					</th>
				</tr>
				
			</table>
	</div>
	
	<div class="container" style="margin-top: 5px; margin-left: 200px; width: 1000px; background-color: brown; color: white;">
		<h3><marquee behavior="alternate" style="width: 500px;">DASHBOARD</marquee></h3>
	</div>
	